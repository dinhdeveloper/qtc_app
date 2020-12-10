package qtc.project.app.fragment.fragment_customer.dashboard;

import android.text.TextUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.api.fragment_customer.contact.RequestContact;
import qtc.project.app.api.fragment_customer.dashboard.RequestListProductHome;
import qtc.project.app.api.fragment_customer.slider.RequestGetSlideHeaderReview;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.event.BackShowRootViewEvent;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ContactModel;
import qtc.project.app.model.customer.ImageSlideModel;
import qtc.project.app.model.customer.ProductHomeModel;
import qtc.project.app.ui.views.fragment.fragment_customer.dashboard.FragmentDashboardCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.dashboard.FragmentDashboardCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.dashboard.FragmentDashboardCustomerViewInterface;

public class FragmentDashboardCustomer extends BaseFragment<FragmentDashboardCustomerViewInterface, BaseParameters> implements FragmentDashboardCustomerViewCallback {

    CustomerActivity activity;
    private int page = 1;
    private int totalPage = 0;

    @Override
    protected void initialize() {
        activity = (CustomerActivity) getActivity();
        view.init(activity, this);

        requestGetData();
    }

    private void requestGetData() {
        requestGetSlideHeader();
        requestGetListNews();
    }

    private void requestGetListNews() {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestListProductHome.ApiParams params = new RequestListProductHome.ApiParams();
        AppProvider.getApiManagement().call(RequestListProductHome.class, params, new ApiRequest.ApiCallback<BaseResponseModel<ProductHomeModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<ProductHomeModel> result) {
                dismissProgress();
                if (!TextUtils.isEmpty(result.getSuccess()) && result.getSuccess().equalsIgnoreCase("true")) {

                    if (!TextUtils.isEmpty(result.getTotal_page())) {
                        totalPage = Integer.valueOf(result.getTotal_page());
                        if (page == totalPage) {
                            view.setNoMoreLoading();
                        }
                    } else {
                        view.setNoMoreLoading();
                    }
                    view.setDataList(result);
                } else {
                    if (!TextUtils.isEmpty(result.getMessage()))
                        showAlert(result.getMessage(), KAlertDialog.ERROR_TYPE);
                    else
                        showAlert("Không thể tải dữ liệu.", KAlertDialog.ERROR_TYPE);
                }
            }

            @Override
            public void onError(ErrorApiResponse error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
            }

            @Override
            public void onFail(ApiRequest.RequestError error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
            }
        });
    }

    private void requestGetSlideHeader() {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        RequestGetSlideHeaderReview.ApiParams params = new RequestGetSlideHeaderReview.ApiParams();

        AppProvider.getApiManagement().call(RequestGetSlideHeaderReview.class, params, new ApiRequest.ApiCallback<BaseResponseModel<ImageSlideModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<ImageSlideModel> result) {

                if (!TextUtils.isEmpty(result.getSuccess()) && result.getSuccess().equalsIgnoreCase("true")) {
                    view.setDataImageSlide(result.getData());
                }
            }

            @Override
            public void onError(ErrorApiResponse error) {
                view.setDataImageSlide(null);
            }

            @Override
            public void onFail(ApiRequest.RequestError error) {
                view.setDataImageSlide(null);
            }
        });
    }

    @Override
    public void refreshLoadingList() {
        page = 1;
        totalPage = 0;
        view.resetListData();
        requestGetListNews();
    }

    @Override
    public void onRequestLoadMoreList() {
        ++page;

        if (totalPage > 0 && page <= totalPage) {

            requestGetListNews();
        } else {
            view.setNoMoreLoading();
            showToast(getString(R.string.error_loadmore));
        }
    }

    @Override
    public void onRequestSearchWithFilter(String status, String key) {

    }

    @Override
    public void onItemListSelected(OptionModel item) {
        ProductHomeModel model = (ProductHomeModel) item.getDtaCustom();
        if (activity != null) {
            activity.changeToFragmentProductDetail(model);
            activity.hideBottomMenuBar();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.hideRootView();
                }
            }, 700);
        }
    }

    @Override
    public void onClickAddItem() {

    }

    @Override
    public void onDeleteItemSelected(OptionModel item) {
    }

    @Override
    public void onClickFilter() {

    }

    @Override
    protected FragmentDashboardCustomerViewInterface getViewInstance() {
        return new FragmentDashboardCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBackShowRootViewEvent(BackShowRootViewEvent event) {
        if (view != null) {
            view.hashCode();
        }
    }
}
