package qtc.project.app.ui.views.fragment.fragment_customer.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.helper.AppUtils;
import b.laixuantam.myaarlibrary.helper.KeyboardUtils;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundTextView;
import b.laixuantam.myaarlibrary.widgets.touch_view_anim.scaletouchlistener.ScaleTouchListener;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;

public class FragmentLoginCustomerView extends BaseView<FragmentLoginCustomerView.UIContainer> implements FragmentLoginCustomerViewInterface{
    CustomerActivity activity;
    FragmentLoginCustomerViewCallback callback;

    @Override
    public void init(CustomerActivity activity, FragmentLoginCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback!=null)
                callback.onBackHeader();
        });

        KeyboardUtils.setupUI(getView(),activity);

        ui.edtLoginName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ui.edtLoginName.getText().length() > 0) {
                    ui.edtLoginName.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ui.edtLoginName.getText().length() > 0) {
                    ui.edtLoginName.setError(null);
                }
            }
        });
        ui.edtLoginPassowrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (ui.edtLoginPassowrd.getText().length() > 0) {
                    ui.edtLoginPassowrd.setError(null);
                }
            }
        });
        ui.edtLoginPassowrd.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                doLogin();
            }
            return false;
        });



        ui.btnLoginButton.setOnClickListener(new ScaleTouchListener(confScaleTouch) {
            @Override
            public void onClick(View v) {
                AppUtils.hideKeyBoard(ui.btnLoginButton);
                doLogin();
            }
        });
    }

    private void doLogin() {
        if (!TextUtils.isEmpty(ui.edtLoginName.getText()) && !TextUtils
                .isEmpty(ui.edtLoginName.getText())) {

            callback.onClickLogin(ui.edtLoginName.getText()
                    .toString(), ui.edtLoginPassowrd
                    .getText()
                    .toString());
        }
        else if (TextUtils.isEmpty(ui.edtLoginName.getText())) {
            ui.edtLoginName.setError("Tên đăng nhập");
            ui.edtLoginName.requestFocus();
        } else {
            ui.edtLoginPassowrd.setError("Mật khẩu");
            ui.edtLoginPassowrd.requestFocus();
        }
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
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.edtLoginName)
        public EditText edtLoginName;

        @UiElement(R.id.edtLoginPassowrd)
        public EditText edtLoginPassowrd;

        @UiElement(R.id.btnLoginButton)
        public RoundTextView btnLoginButton;


    }
}
