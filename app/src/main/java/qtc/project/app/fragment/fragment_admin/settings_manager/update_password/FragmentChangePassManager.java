package qtc.project.app.fragment.fragment_admin.settings_manager.update_password;

import android.text.TextUtils;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.api.fargment_admin.RequestUpdateProfile;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.update_password.FragmentChangePassManagerView;
import qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.update_password.FragmentChangePassManagerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.update_password.FragmentChangePassManagerViewInterface;

public class FragmentChangePassManager extends BaseFragment<FragmentChangePassManagerViewInterface, BaseParameters> implements FragmentChangePassManagerViewCallback {
    AdminActivity activity;

    @Override
    protected void initialize() {
        activity = (AdminActivity) getActivity();
        view.init(activity, this);
    }

    @Override
    protected FragmentChangePassManagerViewInterface getViewInstance() {
        return new FragmentChangePassManagerView();
    }

    @Override
    public void onBackHeader() {
        if (activity != null)
            activity.checkBack();
    }

    @Override
    public void onRequestUpdatePassWord(String old_pass, String new_pass) {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getString(R.string.error_connect_internet), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestUpdateProfile.ApiParams params = new RequestUpdateProfile.ApiParams();
        params.type_manager = "update_password";
        params.id_login = AppProvider.getPreferences().getUserModel().getId_login();
        if (!TextUtils.isEmpty(old_pass)) {
            params.old_pass = old_pass;
        }
        if (!TextUtils.isEmpty(new_pass)) {
            params.new_pass = new_pass;
        }

        AppProvider.getApiManagement().call(RequestUpdateProfile.class, params, new ApiRequest.ApiCallback<BaseResponseModel>() {
            @Override
            public void onSuccess(BaseResponseModel body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                    showAlert(body.getMessage(), KAlertDialog.SUCCESS_TYPE);
                    view.clearData();
                } else {
                    if (!TextUtils.isEmpty(body.getSuccess())) {
                        showAlert(body.getMessage(), KAlertDialog.ERROR_TYPE);
                    }else
                        {
                            showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
                        }
                }
            }

            @Override
            public void onError(ErrorApiResponse error) {
                dismissProgress();
                showAlert("Cập nhật không thành công", KAlertDialog.ERROR_TYPE);
            }

            @Override
            public void onFail(ApiRequest.RequestError error) {
                dismissProgress();
                showAlert("Cập nhật không thành công", KAlertDialog.ERROR_TYPE);
            }
        });
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
