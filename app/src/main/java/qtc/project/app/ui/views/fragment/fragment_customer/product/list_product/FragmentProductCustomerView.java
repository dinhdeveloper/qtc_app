package qtc.project.app.ui.views.fragment.fragment_customer.product.list_product;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.AppUtils;
import b.laixuantam.myaarlibrary.widgets.cptr.PtrClassicFrameLayout;
import b.laixuantam.myaarlibrary.widgets.cptr.PtrDefaultHandler;
import b.laixuantam.myaarlibrary.widgets.cptr.PtrFrameLayout;
import b.laixuantam.myaarlibrary.widgets.cptr.loadmore.OnLoadMoreListener;
import b.laixuantam.myaarlibrary.widgets.cptr.recyclerview.RecyclerAdapterWithHF;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.adapter.customer.ListCategoryProductAdapter;
import qtc.project.app.adapter.customer.ListProductHomeAdapter;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.CategoryProductModel;
import qtc.project.app.model.customer.ProductHomeModel;

public class FragmentProductCustomerView extends BaseView<FragmentProductCustomerView.UIContainer> implements FragmentProductCustomerViewInterface {
    CustomerActivity activity;
    FragmentProductCustomerViewCallback callback;

    private ListProductHomeAdapter productHomeAdapter;
    private RecyclerAdapterWithHF recyclerAdapterWithHF;
    private ArrayList<OptionModel> listDatas = new ArrayList<>();
    private Timer timer = new Timer();
    private final long DELAY = 1000; // in ms
    private boolean isRefreshList = false;

    @Override
    public void init(CustomerActivity activity, FragmentProductCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.tvTitleHeader.setText("Sản phẩm");

        setUpListData();
    }

    private void setUpListData() {
        ui.recycler_view_list_product.getRecycledViewPool().clear();

        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        ui.recycler_view_list_product.setLayoutManager(linearLayoutManager);

        //todo setup list with adapter

        productHomeAdapter = new ListProductHomeAdapter(getContext(), listDatas);

        productHomeAdapter.setListener(item -> {
            if (callback != null)
                callback.onItemListSelected(item);
        });

        recyclerAdapterWithHF = new RecyclerAdapterWithHF(productHomeAdapter);

        ui.recycler_view_list_product.setAdapter(recyclerAdapterWithHF);

        ui.ptrClassicFrameLayout.setLoadMoreEnable(true);

        ui.ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler(true) {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                AppUtils.hideKeyBoard(getView());
                isRefreshList = true;
                listDatas.clear();
                productHomeAdapter.notifyDataSetChanged();
                ui.recycler_view_list_product.getRecycledViewPool().clear();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ui.ptrClassicFrameLayout.refreshComplete();

                        if (callback != null) {
                            callback.refreshLoadingList();
                            isRefreshList = false;
                        }
                    }
                }, 100);


            }
        });

        ui.ptrClassicFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void loadMore() {
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        if (callback != null)
                            callback.onRequestLoadMoreList();

                    }
                }, 100);
            }
        });
    }

    @Override
    public void setDataCategoryProduct(CategoryProductModel[] data) {
        if (data != null && data.length > 0) {
            ui.recycler_view_list_category.getRecycledViewPool().clear();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            ui.recycler_view_list_category.setLayoutManager(linearLayoutManager);
            //todo setup list with adapter
            List<CategoryProductModel> list = new ArrayList<>();
            list.addAll(Arrays.asList(data));
            ListCategoryProductAdapter productHomeAdapter = new ListCategoryProductAdapter(getContext(), list);
            ui.recycler_view_list_category.setAdapter(productHomeAdapter);

            productHomeAdapter.setListener(model -> {
                if (callback != null) {
                    callback.getListDataProductByIdCategory(model.getId());
                }
            });
        } else {
            showEmptyList();
        }
    }

    @Override
    public void showEmptyList() {
        setVisible(ui.layoutEmptyList);
        setGone(ui.ptrClassicFrameLayout);
    }

    @Override
    public void hideEmptyList() {
        setGone(ui.layoutEmptyList);
        setVisible(ui.ptrClassicFrameLayout);
    }

    @Override
    public void setDataList(BaseResponseModel dataList) {
        ui.recycler_view_list_product.getRecycledViewPool().clear();

        if (dataList.getData() == null || dataList.getData().length == 0) {
            if (listDatas.size() == 0)
                showEmptyList();
            return;
        }

        hideEmptyList();

//        listDatas.addAll(Arrays.asList(arrDatas));
        ProductHomeModel[] arrOrder = (ProductHomeModel[]) dataList.getData();

        for (ProductHomeModel itemOrderModel : arrOrder) {
            OptionModel optionModel = new OptionModel();
            optionModel.setDtaCustom(itemOrderModel);
            listDatas.add(optionModel);
        }

        recyclerAdapterWithHF.notifyDataSetChanged();
        ui.ptrClassicFrameLayout.loadMoreComplete(true);
        ui.ptrClassicFrameLayout.setLoadMoreEnable(true);
    }

    @Override
    public void setNoMoreLoading() {
        ui.ptrClassicFrameLayout.loadMoreComplete(true);
        ui.ptrClassicFrameLayout.setLoadMoreEnable(false);
    }

    @Override
    public void resetListData() {
        listDatas.clear();
        productHomeAdapter.notifyDataSetChanged();
        ui.recycler_view_list_product.getRecycledViewPool().clear();
    }

    @Override
    public void hideRootView() {
        setGone(ui.layoutRootView);
    }

    @Override
    public void showRootView() {
        setVisible(ui.layoutRootView);
    }

    @Override
    public void clearListData() {
        listDatas.clear();
        productHomeAdapter.notifyDataSetChanged();
        ui.recycler_view_list_product.getRecycledViewPool().clear();
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentProductCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_product_customer;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.layoutRootView)
        public View layoutRootView;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.recycler_view_list_category)
        public RecyclerView recycler_view_list_category;

        @UiElement(R.id.recycler_view_list_product)
        public RecyclerView recycler_view_list_product;

        @UiElement(R.id.ptrClassicFrameLayout)
        public PtrClassicFrameLayout ptrClassicFrameLayout;

        @UiElement(R.id.layoutEmptyList)
        public View layoutEmptyList;

    }
}
