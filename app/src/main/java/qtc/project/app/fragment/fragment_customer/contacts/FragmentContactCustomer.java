package qtc.project.app.fragment.fragment_customer.contacts;

import android.text.TextUtils;
import android.widget.TableRow;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.api.fragment_customer.contact.RequestContact;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ContactModel;
import qtc.project.app.ui.views.fragment.fragment_customer.contacts.FragmentContactCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.contacts.FragmentContactCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.contacts.FragmentContactCustomerViewInterface;

public class FragmentContactCustomer extends BaseFragment<FragmentContactCustomerViewInterface, BaseParameters> implements FragmentContactCustomerViewCallback {
    CustomerActivity activity;

    @Override
    protected void initialize() {
        activity = (CustomerActivity) getActivity();
        view.init(activity, this);

        requestContact();
    }

    private void requestContact() {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestContact.ApiParams params = new RequestContact.ApiParams();
        AppProvider.getApiManagement().call(RequestContact.class, params, new ApiRequest.ApiCallback<BaseResponseModel<ContactModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<ContactModel> body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                        view.setDataContact(body.getData());
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
    public void changeToFragmentLogin() {
        if (activity != null)
            activity.changeToFragmentLogin();
    }

    @Override
    protected FragmentContactCustomerViewInterface getViewInstance() {
        return new FragmentContactCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
