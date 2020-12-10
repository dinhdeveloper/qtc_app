package qtc.project.app.fragment.fragment_customer.product;

import android.text.TextUtils;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.api.fragment_customer.dashboard.RequestListProductHome;
import qtc.project.app.api.fragment_customer.product.RequestCategoryProduct;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.CategoryProductModel;
import qtc.project.app.model.customer.ProductHomeModel;
import qtc.project.app.ui.views.fragment.fragment_customer.product.list_product.FragmentProductCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.product.list_product.FragmentProductCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.product.list_product.FragmentProductCustomerViewInterface;

public class FragmentProductCustomer extends BaseFragment<FragmentProductCustomerViewInterface, BaseParameters> implements FragmentProductCustomerViewCallback {
    CustomerActivity activity;
    private int page = 1;
    private int totalPage = 0;
    @Override
    protected void initialize() {
        activity = (CustomerActivity) getActivity();
        view.init(activity, this);

        requestGetCategoryProduct();
    }

    private void requestGetCategoryProduct() {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestCategoryProduct.ApiParams params = new RequestCategoryProduct.ApiParams();
        AppProvider.getApiManagement().call(RequestCategoryProduct.class, params, new ApiRequest.ApiCallback<BaseResponseModel<CategoryProductModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<CategoryProductModel> body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                    view.setDataCategoryProduct(body.getData());
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
    String id_category;
    @Override
    public void getListDataProductByIdCategory(String id) {
        this.id_category = id;
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestListProductHome.ApiParams params = new RequestListProductHome.ApiParams();
        if (!TextUtils.isEmpty(id)) {
            params.id_category = id;
        }
        view.resetListData();
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

    @Override
    public void refreshLoadingList() {
        page = 1;
        totalPage = 0;
        view.resetListData();
        getListDataProductByIdCategory(id_category);
    }

    @Override
    public void onRequestLoadMoreList() {
        ++page;

        if (totalPage > 0 && page <= totalPage) {

            getListDataProductByIdCategory(id_category);
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
    protected FragmentProductCustomerViewInterface getViewInstance() {
        return new FragmentProductCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
