package qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.update_password;

import android.text.InputType;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundTextView;
import qtc.project.app.R;
import qtc.project.app.activity.AdminActivity;

public class FragmentChangePassManagerView extends BaseView<FragmentChangePassManagerView.UIContainer> implements FragmentChangePassManagerViewInterface {
    AdminActivity activity;
    FragmentChangePassManagerViewCallback callback;
    private boolean isVisibleNewPassword, isVisibleCurrentPassword, isVisibleConfirmNewPassword;
    @Override
    public void init(AdminActivity activity, FragmentChangePassManagerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        ui.tvTitleHeader.setText("Thay đổi mật khẩu");
        setVisible(ui.btnBackHeader);
        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback != null)
                callback.onBackHeader();
        });

        onClick();
    }
    private void onClick() {
        ui.btnVisibleNewPassword.setOnClickListener(v -> {
            if (!isVisibleNewPassword) {
                isVisibleNewPassword = true;
                ui.edtNewPassowrd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                if (!"".contentEquals(ui.edtNewPassowrd.getText()))
                    ui.edtNewPassowrd.setSelection(ui.edtNewPassowrd.getText().length());
                ui.btnVisibleNewPassword.setBackgroundResource(R.drawable.dinh_ic_visible);
            } else {
                isVisibleNewPassword = false;
                ui.edtNewPassowrd.setInputType(129);
                if (!"".contentEquals(ui.edtNewPassowrd.getText()))
                    ui.edtNewPassowrd.setSelection(ui.edtNewPassowrd.getText().length());
                ui.btnVisibleNewPassword.setBackgroundResource(R.drawable.ic_qtc_invisible_pass);
            }
        });

        ui.btnVisibleCurrentPassword.setOnClickListener(v -> {
            if (!isVisibleCurrentPassword) {
                isVisibleCurrentPassword = true;
                ui.edtCurrentPassowrd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                if (!"".contentEquals(ui.edtCurrentPassowrd.getText()))
                    ui.edtCurrentPassowrd.setSelection(ui.edtCurrentPassowrd.getText().length());
                ui.btnVisibleCurrentPassword.setBackgroundResource(R.drawable.dinh_ic_visible);
            } else {
                isVisibleCurrentPassword = false;
                ui.edtCurrentPassowrd.setInputType(129);
                if (!"".contentEquals(ui.edtCurrentPassowrd.getText()))
                    ui.edtCurrentPassowrd.setSelection(ui.edtCurrentPassowrd.getText().length());
                ui.btnVisibleCurrentPassword.setBackgroundResource(R.drawable.ic_qtc_invisible_pass);
            }
        });

        ui.btnVisibleConfirmNewPassword.setOnClickListener(v -> {
            if (!isVisibleConfirmNewPassword) {
                isVisibleConfirmNewPassword = true;
                ui.edtConfirmNewPassowrd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                if (!"".contentEquals(ui.edtConfirmNewPassowrd.getText()))
                    ui.edtConfirmNewPassowrd.setSelection(ui.edtConfirmNewPassowrd.getText().length());
                ui.btnVisibleConfirmNewPassword.setBackgroundResource(R.drawable.dinh_ic_visible);
            } else {
                isVisibleConfirmNewPassword = false;
                ui.edtConfirmNewPassowrd.setInputType(129);
                if (!"".contentEquals(ui.edtConfirmNewPassowrd.getText()))
                    ui.edtConfirmNewPassowrd.setSelection(ui.edtConfirmNewPassowrd.getText().length());
                ui.btnVisibleConfirmNewPassword.setBackgroundResource(R.drawable.ic_qtc_invisible_pass);
            }
        });

        ui.btnSubmitUpdatePassword.setOnClickListener(v -> {
            if (checkDataInput()) {
                onRequestSignUp();
            }
        });
    }
    private void onRequestSignUp() {
        if (ui.edtNewPassowrd.getText().toString().trim().length() < 6) {
            if (activity != null) {
                activity.showAlert("Mật khẩu phải chứa ít nhất 6 ký tự.", KAlertDialog.ERROR_TYPE);
            } else {
                Toast.makeText(getContext(), "Mật khẩu phải chứa ít nhất 6 ký tự.", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        if (!ui.edtNewPassowrd.getText().toString().trim().equalsIgnoreCase(ui.edtConfirmNewPassowrd.getText().toString().trim())) {
            if (activity != null) {
                activity.showAlert("Mật khẩu không trùng nhau.", KAlertDialog.ERROR_TYPE);
                return;
            }

        }

        String old_pass = ui.edtCurrentPassowrd.getText().toString().trim();
        String new_pass = ui.edtNewPassowrd.getText().toString().trim();

        if (callback!=null)
            callback.onRequestUpdatePassWord(old_pass,new_pass);
    }
    private boolean checkDataInput() {
        if (TextUtils.isEmpty(ui.edtCurrentPassowrd.getText().toString().trim())) {
            ui.edtCurrentPassowrd.setError("Nhập mật khẩu cũ");
            ui.edtCurrentPassowrd.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(ui.edtNewPassowrd.getText().toString().trim())) {
            ui.edtNewPassowrd.setError("Nhập mật khẩu đăng ký");
            ui.edtNewPassowrd.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(ui.edtConfirmNewPassowrd.getText().toString().trim())) {
            ui.edtConfirmNewPassowrd.setError("Nhập lại mật khẩu đăng ký");
            ui.edtConfirmNewPassowrd.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void clearData() {
        ui.edtConfirmNewPassowrd.setText("");
        ui.edtCurrentPassowrd.setText("");
        ui.edtNewPassowrd.setText("");
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentChangePassManagerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_layout_fragment_change_password;
    }


    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.imvAction2)
        public ImageView imvAction2;

        @UiElement(R.id.edtCurrentPassowrd)
        public EditText edtCurrentPassowrd;

        @UiElement(R.id.edtNewPassowrd)
        public EditText edtNewPassowrd;

        @UiElement(R.id.edtConfirmNewPassowrd)
        public EditText edtConfirmNewPassowrd;

        @UiElement(R.id.btnSubmitUpdatePassword)
        public RoundTextView btnSubmitUpdatePassword;

        @UiElement(R.id.btnVisibleCurrentPassword)
        public ImageView btnVisibleCurrentPassword;

        @UiElement(R.id.btnVisibleNewPassword)
        public ImageView btnVisibleNewPassword;

        @UiElement(R.id.btnVisibleConfirmNewPassword)
        public ImageView btnVisibleConfirmNewPassword;



    }
}
