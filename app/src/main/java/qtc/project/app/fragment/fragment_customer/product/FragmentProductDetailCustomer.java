package qtc.project.app.fragment.fragment_customer.product;

import android.os.Bundle;
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
import qtc.project.app.api.fragment_customer.dashboard.RequestListProductHome;
import qtc.project.app.api.fragment_customer.product.RequestProductDetail;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.event.BackShowRootViewEvent;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ProductDetailModel;
import qtc.project.app.model.customer.ProductHomeModel;
import qtc.project.app.ui.views.fragment.fragment_customer.product.detail_product.FragmentProductDetailCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.product.detail_product.FragmentProductDetailCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.product.detail_product.FragmentProductDetailCustomerViewInterface;

public class FragmentProductDetailCustomer extends BaseFragment<FragmentProductDetailCustomerViewInterface, BaseParameters> implements FragmentProductDetailCustomerViewCallback {
    CustomerActivity activity;
    private int page = 1;
    private int totalPage = 0;
    ProductHomeModel modelLocal;

    public static FragmentProductDetailCustomer newInstance(ProductHomeModel model) {

        Bundle args = new Bundle();
        args.putSerializable("model", model);
        FragmentProductDetailCustomer fragment = new FragmentProductDetailCustomer();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initialize() {
        activity = (CustomerActivity) getActivity();
        view.init(activity, this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ProductHomeModel model = (ProductHomeModel) bundle.getSerializable("model");
            requestDataProductDetail(model);
            requestDataProductRandom(model);
            this.modelLocal = model;
        }
    }

    private void requestDataProductRandom(ProductHomeModel model) {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestListProductHome.ApiParams params = new RequestListProductHome.ApiParams();
        params.id_category = model.getId_category();
        params.id_product = model.getId();
        AppProvider.getApiManagement().call(RequestListProductHome.class, params, new ApiRequest.ApiCallback<BaseResponseModel<ProductHomeModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<ProductHomeModel> result) {
                dismissProgress();
                if (!TextUtils.isEmpty(result.getSuccess()) && result.getSuccess().equalsIgnoreCase("true")) {
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

    private void requestDataProductDetail(ProductHomeModel model) {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestProductDetail.ApiParams params = new RequestProductDetail.ApiParams();
        if (!TextUtils.isEmpty(model.getId())) {
            params.product_id = model.getId();
        }
        AppProvider.getApiManagement().call(RequestProductDetail.class, params, new ApiRequest.ApiCallback<BaseResponseModel<ProductDetailModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<ProductDetailModel> body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                    view.setDataProductDetail(body.getData());
                } else {
                    showAlert(body.getMessage(), KAlertDialog.ERROR_TYPE);
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
    public void onBackHeader() {
        if (activity != null) {
            activity.checkBack();
            activity.showBottomMenuBar();
            BackShowRootViewEvent.post();
        }
    }

    @Override
    protected FragmentProductDetailCustomerViewInterface getViewInstance() {
        return new FragmentProductDetailCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBackShowRootViewEvent(BackShowRootViewEvent event) {
        if (view != null) {
            view.showRootView();
        }
    }
}
