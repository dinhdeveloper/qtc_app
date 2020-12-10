package qtc.project.app.fragment.fragment_customer.introduce;

import android.text.TextUtils;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.api.fragment_customer.about_us.RequestAboutUs;
import qtc.project.app.api.fragment_customer.contact.RequestContact;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.AboutUsModel;
import qtc.project.app.model.customer.ContactModel;
import qtc.project.app.ui.views.fragment.fragment_customer.introduce.FragmentIntroduceCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.introduce.FragmentIntroduceCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.introduce.FragmentIntroduceCustomerViewInterface;

public class FragmentIntroduceCustomer extends BaseFragment<FragmentIntroduceCustomerViewInterface, BaseParameters> implements FragmentIntroduceCustomerViewCallback {

    CustomerActivity activity;

    @Override
    protected void initialize() {
        activity = (CustomerActivity) getActivity();
        view.init(activity, this);
        
        requestIntroduce();
    }

    private void requestIntroduce() {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestAboutUs.ApiParams params = new RequestAboutUs.ApiParams();
        AppProvider.getApiManagement().call(RequestAboutUs.class, params, new ApiRequest.ApiCallback<BaseResponseModel<AboutUsModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<AboutUsModel> body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                    view.setDataAboutUs(body.getData());
                }else {
                    showAlert(body.getMessage(),KAlertDialog.ERROR_TYPE);
                }
            }

            @Override
            public void onError(ErrorApiResponse error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu",KAlertDialog.ERROR_TYPE);
            }

            @Override
            public void onFail(ApiRequest.RequestError error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu",KAlertDialog.ERROR_TYPE);
            }
        });
    }

    @Override
    protected FragmentIntroduceCustomerViewInterface getViewInstance() {
        return new FragmentIntroduceCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
