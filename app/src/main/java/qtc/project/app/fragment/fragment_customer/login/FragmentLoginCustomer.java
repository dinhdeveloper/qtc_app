package qtc.project.app.fragment.fragment_customer.login;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import qtc.project.app.activity.CustomerActivity;
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
    protected FragmentLoginCustomerViewInterface getViewInstance() {
        return new FragmentLoginCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
