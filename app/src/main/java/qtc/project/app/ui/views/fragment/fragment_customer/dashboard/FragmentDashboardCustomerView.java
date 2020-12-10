package qtc.project.app.ui.views.fragment.fragment_customer.dashboard;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Timer;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.AppUtils;
import b.laixuantam.myaarlibrary.widgets.cptr.PtrClassicFrameLayout;
import b.laixuantam.myaarlibrary.widgets.cptr.PtrDefaultHandler;
import b.laixuantam.myaarlibrary.widgets.cptr.PtrFrameLayout;
import b.laixuantam.myaarlibrary.widgets.cptr.loadmore.OnLoadMoreListener;
import b.laixuantam.myaarlibrary.widgets.cptr.recyclerview.RecyclerAdapterWithHF;
import b.laixuantam.myaarlibrary.widgets.viewpage.ViewPagerIndicator;
import io.supercharge.shimmerlayout.ShimmerLayout;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.adapter.SlidingImage_Adapter;
import qtc.project.app.adapter.customer.ListProductHomeAdapter;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ImageSlideModel;
import qtc.project.app.model.customer.ProductHomeModel;

public class FragmentDashboardCustomerView extends BaseView<FragmentDashboardCustomerView.UIContainer> implements FragmentDashboardCustomerViewInterface {
    CustomerActivity activity;
    FragmentDashboardCustomerViewCallback callback;
    private int currentPage = 0;
    private int NUM_PAGES = 0;

    private ListProductHomeAdapter productHomeAdapter;
    private RecyclerAdapterWithHF recyclerAdapterWithHF;
    private ArrayList<OptionModel> listDatas = new ArrayList<>();
    private Timer timer = new Timer();
    private final long DELAY = 1000; // in ms
    private boolean isRefreshList = false;

    @Override
    public void init(CustomerActivity activity, FragmentDashboardCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        setUpListData();
    }

    private void setUpListData() {
        ui.recycler_view_list.getRecycledViewPool().clear();

        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        ui.recycler_view_list.setLayoutManager(linearLayoutManager);

        //todo setup list with adapter

        productHomeAdapter = new ListProductHomeAdapter(getContext(), listDatas);

        productHomeAdapter.setListener(item -> {
            if (callback != null)
                callback.onItemListSelected(item);
        });

        recyclerAdapterWithHF = new RecyclerAdapterWithHF(productHomeAdapter);

        ui.recycler_view_list.setAdapter(recyclerAdapterWithHF);

        ui.ptrClassicFrameLayout.setLoadMoreEnable(true);

        ui.ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler(true) {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                AppUtils.hideKeyBoard(getView());
                isRefreshList = true;
                listDatas.clear();
                productHomeAdapter.notifyDataSetChanged();
                ui.recycler_view_list.getRecycledViewPool().clear();
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
    public void setDataImageSlide(ImageSlideModel[] data) {
        if (data != null && data.length > 0) {
            setVisible(ui.layoutHeaderSlide);
            setGone(ui.layoutShimmerSliderDashboard);
            setGone(ui.viewEmptyImageSlider);
            setVisible(ui.layoutSliderImage);

            ArrayList<String> listImage = new ArrayList<>();

            for (ImageSlideModel itemSlide : data) {
                listImage.add(itemSlide.getImg_1920_1080());
            }

            NUM_PAGES = listImage.size();
            SlidingImage_Adapter slidingImage_adapter = new SlidingImage_Adapter(activity, SlidingImage_Adapter.SliderImageType.LINK);
            slidingImage_adapter.setIMAGE_LINK(listImage);
            ui.pager_slider_image.setAdapter(slidingImage_adapter);

            ui.indicator_pager_slider_image.setupWithViewPager(ui.pager_slider_image);

            handler.post(loopSliderImage);

            // Pager listener over indicator
            ui.indicator_pager_slider_image.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;

                }

                @Override
                public void onPageScrolled(int pos, float arg1, int arg2) {

                }

                @Override
                public void onPageScrollStateChanged(int pos) {

                }
            });
        } else {
            setGone(ui.layoutHeaderSlide);
            setVisible(ui.viewEmptyImageSlider);
            setGone(ui.layoutShimmerSliderDashboard);
            setGone(ui.layoutSliderImage);
        }
    }

    private final Runnable loopSliderImage = new Runnable() {
        public void run() {
            if (currentPage == NUM_PAGES) {
                currentPage = 0;
            }
            ui.pager_slider_image.setCurrentItem(currentPage++, true);
            handler.postDelayed(this, 2000);
        }
    };

    @Override
    public void setNoMoreLoading() {
        ui.ptrClassicFrameLayout.loadMoreComplete(true);
        ui.ptrClassicFrameLayout.setLoadMoreEnable(false);
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
        ui.recycler_view_list.getRecycledViewPool().clear();

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
    public void resetListData() {
        listDatas.clear();
        productHomeAdapter.notifyDataSetChanged();
        ui.recycler_view_list.getRecycledViewPool().clear();
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
        ui.recycler_view_list.getRecycledViewPool().clear();
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentDashboardCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_dashboard_customer;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.layoutRootView)
        public View layoutRootView;

        @UiElement(R.id.layoutSliderImage)
        public View layoutSliderImage;

        @UiElement(R.id.layoutHeaderSlide)
        public View layoutHeaderSlide;

        @UiElement(R.id.pager_slider_image)
        public ViewPager pager_slider_image;

        @UiElement(R.id.indicator_pager_slider_image)
        public ViewPagerIndicator indicator_pager_slider_image;

        @UiElement(R.id.viewEmptyImageSlider)
        public View viewEmptyImageSlider;

        @UiElement(R.id.layoutShimmerSliderDashboard)
        public View layoutShimmerSliderDashboard;

        @UiElement(R.id.shimmer_layout_slider)
        public ShimmerLayout shimmer_layout_slider;

        @UiElement(R.id.recycler_view_list)
        public RecyclerView recycler_view_list;

        @UiElement(R.id.ptrClassicFrameLayout)
        public PtrClassicFrameLayout ptrClassicFrameLayout;

        @UiElement(R.id.layoutEmptyList)
        public View layoutEmptyList;


    }
}
