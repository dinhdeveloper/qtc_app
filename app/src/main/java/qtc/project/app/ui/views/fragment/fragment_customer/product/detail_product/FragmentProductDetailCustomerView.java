package qtc.project.app.ui.views.fragment.fragment_customer.product.detail_product;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import b.laixuantam.myaarlibrary.widgets.cptr.recyclerview.RecyclerAdapterWithHF;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.adapter.customer.ListPhotoProductAdapter;
import qtc.project.app.adapter.customer.ListProductHomeAdapter;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.helper.Consts;
import qtc.project.app.helper.PredicateLayout;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.HashTagModel;
import qtc.project.app.model.customer.ProductDetailModel;
import qtc.project.app.model.customer.ProductHomeModel;
import qtc.project.app.model.customer.PhotoModel;

public class FragmentProductDetailCustomerView extends BaseView<FragmentProductDetailCustomerView.UIContainer> implements FragmentProductDetailCustomerViewInterface {

    CustomerActivity activity;
    FragmentProductDetailCustomerViewCallback callback;

    private ListProductHomeAdapter productHomeAdapter;
    private RecyclerAdapterWithHF recyclerAdapterWithHF;
    private ArrayList<OptionModel> listDatas = new ArrayList<>();
    private Timer timer = new Timer();
    private final long DELAY = 1000; // in ms
    private boolean isRefreshList = false;

    @Override
    public void init(CustomerActivity activity, FragmentProductDetailCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.tvTitleHeader.setText("Chi tiết sản phẩm");
        ui.btnBackHeader.setVisibility(View.VISIBLE);
        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback != null)
                callback.onBackHeader();
        });

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
    }
    private final List<HashTagModel> listHotkey = new ArrayList<>();
    @Override
    public void setDataProductDetail(ProductDetailModel[] data) {
        if (data != null && data.length > 0) {
            ProductDetailModel model = data[0];
            if (model.getProduct_photo()[0] != null) {
                AppProvider.getImageHelper().displayImage(Consts.HOST_API + model.getProduct_photo()[0].getImg_370_530(), ui.imvProductAvata, null, R.drawable.no_image_full);
            }
            if (!TextUtils.isEmpty(model.getCategory_title())) {
                ui.tvCategoryName.setText(model.getCategory_title());
            }
            if (!TextUtils.isEmpty(model.getProduct_price())) {
                ui.tvPrice.setText(model.getProduct_price());
            }
            if (!TextUtils.isEmpty(model.getProduct_description())) {
                ui.tvDescription.setText(model.getProduct_description());
            }

            if (!TextUtils.isEmpty(model.getProduct_short_description())) {
                ui.tvDescriptionShort.setText(model.getProduct_short_description());
            }
            if (!TextUtils.isEmpty(model.getProduct_specification())) {
                ui.tvThongSoKiThuat.setText(model.getProduct_specification());
            }
            if (!TextUtils.isEmpty(model.getProduct_information())) {
                ui.tvThongTinSP.setText(model.getProduct_information());
            }
            if (!TextUtils.isEmpty(model.getProduct_star())) {
                switch (model.getProduct_star()) {
                    case "1":
                        ui.imvStart.setImageResource(R.drawable.ic_qtc_1_star);
                        break;

                    case "2":
                        ui.imvStart.setImageResource(R.drawable.ic_qtc_2_star);
                        break;

                    case "3":
                        ui.imvStart.setImageResource(R.drawable.ic_qtc_3_star);
                        break;

                    case "4":
                        ui.imvStart.setImageResource(R.drawable.ic_qtc_4_star);
                        break;

                    case "5":
                        ui.imvStart.setImageResource(R.drawable.ic_qtc_5_star);
                        break;


                }
            }
            List<PhotoModel> photoModels = new ArrayList<>();
            if (model.getProduct_photo() != null) {
                photoModels.addAll(Arrays.asList(model.getProduct_photo()));
            }
            ListPhotoProductAdapter photoProductAdapter = new ListPhotoProductAdapter(activity, photoModels);
            ui.recycler_view_list_product_photo.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
            ui.recycler_view_list_product_photo.setAdapter(photoProductAdapter);
            photoProductAdapter.notifyDataSetChanged();
            photoProductAdapter.setListener(model1 -> {
                AppProvider.getImageHelper().displayImage(Consts.HOST_API + model1.getImg_370_530(), ui.imvProductAvata, null, R.drawable.no_image_full);
            });

            //hashtag
            if (model.getProduct_tag() != null) {
                LayoutInflater inflater = activity.getLayoutInflater();
                for (HashTagModel item : model.getProduct_tag()) {
                    listHotkey.add(item);
                    @SuppressLint("InflateParams") View keypadLayout = inflater.inflate(R.layout.row_item_hot_key, null);
                    keypadLayout.setLayoutParams(new LinearLayout.LayoutParams(20, 10));

                    TextView textValue = keypadLayout.findViewById(R.id.tvHashTags);
                    textValue.setText("#" + item.getTag_title());

                    textValue.setTag(listHotkey.size() - 1);
                    ui.predicate_layout_hot_key.addView(keypadLayout);
                }
            }
        }
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
    }

    private void hideEmptyList() {

    }

    private void showEmptyList() {
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
    public BaseUiContainer getUiContainer() {
        return new FragmentProductDetailCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_product_detail;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.layoutRootView)
        public View layoutRootView;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvCategoryName)
        public TextView tvCategoryName;

        @UiElement(R.id.imvStart)
        public ImageView imvStart;

        @UiElement(R.id.imvProductAvata)
        public ImageView imvProductAvata;


        @UiElement(R.id.tvDescription)
        public TextView tvDescription;

        @UiElement(R.id.tvPrice)
        public TextView tvPrice;

        @UiElement(R.id.tvDescriptionShort)
        public TextView tvDescriptionShort;

        @UiElement(R.id.tvThongSoKiThuat)
        public TextView tvThongSoKiThuat;

        @UiElement(R.id.tvThongTinSP)
        public TextView tvThongTinSP;

        @UiElement(R.id.predicate_layout_hot_key)
        public PredicateLayout predicate_layout_hot_key;

        @UiElement(R.id.recycler_view_list_product)
        public RecyclerView recycler_view_list_product;

        @UiElement(R.id.recycler_view_list_product_photo)
        public RecyclerView recycler_view_list_product_photo;

    }
}
