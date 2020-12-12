package qtc.project.app.fragment.fragment_customer.acticles;

import android.os.Bundle;
import android.text.TextUtils;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.api.fragment_customer.anticle.RequestNewsDetail;
import qtc.project.app.api.fragment_customer.product.RequestProductDetail;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.event.BackShowRootViewEvent;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.NewsDetailModel;
import qtc.project.app.model.customer.NewsModel;
import qtc.project.app.model.customer.ProductDetailModel;
import qtc.project.app.ui.views.fragment.fragment_customer.acticles.news_detail.FragmentNewsDetailCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.acticles.news_detail.FragmentNewsDetailCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.acticles.news_detail.FragmentNewsDetailCustomerViewInterface;

public class FragmentNewsDetailCustomer extends BaseFragment<FragmentNewsDetailCustomerViewInterface, BaseParameters> implements FragmentNewsDetailCustomerViewCallback {
    CustomerActivity activity;

    public static FragmentNewsDetailCustomer newInstance(NewsModel model) {

        Bundle args = new Bundle();
        args.putSerializable("model", model);
        FragmentNewsDetailCustomer fragment = new FragmentNewsDetailCustomer();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initialize() {
        activity = (CustomerActivity) getActivity();
        view.init(activity, this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            NewsModel model = (NewsModel)bundle.getSerializable("model");
            requestGetDataNewDetail(model);
        }
    }

    private void requestGetDataNewDetail(NewsModel model) {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestNewsDetail.ApiParams params = new RequestNewsDetail.ApiParams();
        if (!TextUtils.isEmpty(model.getId())) {
            params.product_id = model.getId();
        }
        AppProvider.getApiManagement().call(RequestNewsDetail.class, params, new ApiRequest.ApiCallback<BaseResponseModel<NewsDetailModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<NewsDetailModel> body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                    view.setDataNews(body.getData());
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
    public void onBackHeader() {
        if (activity != null) {
            activity.checkBack();
            activity.showBottomMenuBar();
            BackShowRootViewEvent.post();
        }
    }

    @Override
    protected FragmentNewsDetailCustomerViewInterface getViewInstance() {
        return new FragmentNewsDetailCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
