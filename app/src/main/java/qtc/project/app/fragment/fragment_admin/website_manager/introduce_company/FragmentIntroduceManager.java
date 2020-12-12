package qtc.project.app.fragment.fragment_admin.website_manager.introduce_company;

import android.text.TextUtils;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.api.fragment_customer.introduce_company.RequestUpdateIntroduceCompany;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.CompanyModel;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.list_introduce_company.FragmentIntroduceManagerView;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.list_introduce_company.FragmentIntroduceManagerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.list_introduce_company.FragmentIntroduceManagerViewInterface;

public class FragmentIntroduceManager extends BaseFragment<FragmentIntroduceManagerViewInterface, BaseParameters> implements FragmentIntroduceManagerViewCallback {

    AdminActivity activity;

    @Override
    protected void initialize() {
        activity = (AdminActivity) getActivity();
        view.init(activity, this);

        requestIntroduceManager();
    }

    private void requestIntroduceManager() {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestUpdateIntroduceCompany.ApiParams params = new RequestUpdateIntroduceCompany.ApiParams();
        params.type_manager = "list_introduce_company";
        AppProvider.getApiManagement().call(RequestUpdateIntroduceCompany.class, params, new ApiRequest.ApiCallback<BaseResponseModel<CompanyModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<CompanyModel> body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                    view.setDataList(body.getData());
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
    public void onCompanyIntroduceDetail(CompanyModel data) {
        if (activity!=null)
            activity.changeToFragmentCompanyIntroduceDetail(data);
    }

//    @Override
//    public void updateIntroduceCompany(CompanyModel model) {
//        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
//            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
//            return;
//        }
//        showProgress();
//        RequestUpdateIntroduceCompany.ApiParams params = new RequestUpdateIntroduceCompany.ApiParams();
//        params.type_manager = "update";
//        if (!TextUtils.isEmpty(model.getAbout_title())) {
//            params.about_title = model.getAbout_title();
//        }
//        if (!TextUtils.isEmpty(model.getAbout_title())) {
//            params.about_title = model.getAbout_title();
//        }
//        if (!TextUtils.isEmpty(model.getAbout_content())) {
//            params.about_content = model.getAbout_content();
//        }
//
//        AppProvider.getApiManagement().call(RequestUpdateIntroduceCompany.class, params, new ApiRequest.ApiCallback<BaseResponseModel>() {
//            @Override
//            public void onSuccess(BaseResponseModel body) {
//                dismissProgress();
//                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
//                    showAlert(body.getMessage(), KAlertDialog.SUCCESS_TYPE);
//                } else {
//                    showAlert(body.getMessage(), KAlertDialog.ERROR_TYPE);
//                }
//            }
//
//            @Override
//            public void onError(ErrorApiResponse error) {
//                dismissProgress();
//                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
//            }
//
//            @Override
//            public void onFail(ApiRequest.RequestError error) {
//                dismissProgress();
//                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
//            }
//        });
//    }

    @Override
    public void onBackHeader() {
        if (activity != null)
            activity.checkBack();
    }

    @Override
    protected FragmentIntroduceManagerViewInterface getViewInstance() {
        return new FragmentIntroduceManagerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
