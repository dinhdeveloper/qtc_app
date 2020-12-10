package qtc.project.app.ui.views.fragment.fragment_customer.login;

import android.widget.EditText;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundTextView;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;

public class FragmentLoginCustomerView extends BaseView<FragmentLoginCustomerView.UIContainer> implements FragmentLoginCustomerViewInterface{
    CustomerActivity activity;
    FragmentLoginCustomerViewCallback callback;

    @Override
    public void init(CustomerActivity activity, FragmentLoginCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentLoginCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_login_customer;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.edtLoginName)
        public EditText edtLoginName;

        @UiElement(R.id.edtLoginPassowrd)
        public EditText edtLoginPassowrd;

        @UiElement(R.id.btnLoginButton)
        public RoundTextView btnLoginButton;


    }
}
