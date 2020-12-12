package qtc.project.app.fragment.fragment_customer.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.api.account.login.LoginRequest;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.UserResponseModel;
import qtc.project.app.ui.views.fragment.fragment_customer.login.FragmentLoginCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.login.FragmentLoginCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.login.FragmentLoginCustomerViewInterface;

public class FragmentLoginCustomer extends BaseFragment<FragmentLoginCustomerViewInterface, BaseParameters> implements FragmentLoginCustomerViewCallback {
    CustomerActivity activity;

    @Override
    protected void initialize() {
        activity = (CustomerActivity) getActivity();
        view.init(activity, this);
    }

    @Override
    public void onBackHeader() {
        if (activity != null)
            activity.checkBack();
        activity.showBottomMenuBar();
    }

    @Override
    protected FragmentLoginCustomerViewInterface getViewInstance() {
        return new FragmentLoginCustomerView();
    }

    @Override
    public void onClickLogin(String username, String password) {
        requestLogin(username, password);
    }

    private void requestLogin(String username, String password) {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getString(R.string.error_connect_internet), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress(getString(R.string.loading));
        LoginRequest.ApiParams params = new LoginRequest.ApiParams();
        params.username = username;
        params.detect = "user_login";
        params.password = password;

        AppProvider.getApiManagement().call(LoginRequest.class, params, new ApiRequest.ApiCallback<BaseResponseModel<UserResponseModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<UserResponseModel> result) {
                dismissProgress();

                if (!TextUtils.isEmpty(result.getSuccess()) && Objects.requireNonNull(result.getSuccess()).equalsIgnoreCase("true")) {

                    UserResponseModel userModel = result.getData()[0];
                    //luu trang thai login.
                    AppProvider.getPreferences().saveStatusLogin(true);
                    if (result.getData() != null && result.getData().length > 0) {
                        AppProvider.getPreferences().saveUserModel(userModel);
                    }
                    if (activity != null) {
                        activity.goToHome();
                    }
                } else {

                }
            }

            @Override
            public void onError(ErrorApiResponse error) {
                showAlert("Đăng nhập không thành công", KAlertDialog.ERROR_TYPE);
            }

            @Override
            public void onFail(ApiRequest.RequestError error) {
                showAlert("Đăng nhập không thành công", KAlertDialog.ERROR_TYPE);
            }
        });
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
