package qtc.project.app.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import b.laixuantam.myaarlibrary.base.BaseFragmentActivity;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.OnKeyboardVisibilityListener;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.fragment.fragment_admin.website_manager.introduce_company.FragmentCompanyIntroduceDetail;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.fragment.fragment_admin.settings_manager.dash_board.FragmentSettingManager;
import qtc.project.app.fragment.fragment_admin.settings_manager.update_password.FragmentChangePassManager;
import qtc.project.app.fragment.fragment_admin.website_manager.dash_board.FragmentWebsiteManager;
import qtc.project.app.fragment.fragment_admin.website_manager.introduce_company.FragmentIntroduceManager;
import qtc.project.app.fragment.fragment_admin.website_manager.slide_home.FragmentSlideManager;
import qtc.project.app.model.customer.CompanyModel;
import qtc.project.app.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewCallback;
import qtc.project.app.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewInterface;
import qtc.project.app.ui.views.activity.admin_activity.AdminActivityView;
import qtc.project.app.ui.views.activity.admin_activity.AdminActivityViewCallback;
import qtc.project.app.ui.views.activity.admin_activity.AdminActivityViewInterface;

public class AdminActivity extends BaseFragmentActivity<AdminActivityViewInterface, BaseMainActionbarViewInterface, BaseParameters> implements BaseMainActionbarViewCallback, AdminActivityViewCallback, ActivityCompat.OnRequestPermissionsResultCallback, OnKeyboardVisibilityListener {
    private int isShowContainer = 0;

    @Override
    protected void initialize(Bundle savedInstanceState) {
        view.init(this, this);
    }

    public void checkBack() {
        if (isShowContainer > 0) {
            isShowContainer--;
            FragmentManager fm = getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            }

            if (isShowContainer == 0) {
//                if (listProductOrder != null) {
//                    int countItemOrder = countOrderProduct();
//                    if (countItemOrder > 0) {
//                        view.setBadgeCart(countItemOrder);
//                    }
//
//
//                }
            }

        } else {
            checkFragment();
        }
    }

    private void checkFragment() {

        FragmentManager fm = getSupportFragmentManager();

        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void changeToFragmentWebsiteManager() {
        replaceFragment(new FragmentWebsiteManager(),true,Animation.SLIDE_IN_OUT);
    }

    @Override
    public void changeToFragmentNewsManager() {

    }

    @Override
    public void changeToFragmentProductManager() {

    }

    @Override
    public void changeToFragmentSettingsManager() {
        replaceFragment(new FragmentSettingManager(),true,Animation.SLIDE_IN_OUT);
    }

    @Override
    protected AdminActivityViewInterface getViewInstance() {
        return new AdminActivityView();
    }

    @Override
    protected BaseMainActionbarViewInterface getActionbarInstance() {
        return null;
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.layout_frame;
    }

    @Override
    public void onVisibilityChanged(boolean visible) {

    }

    @Override
    public void onFilterToggle(boolean showFilter) {

    }

    @Override
    public void onFiltering(String keyword) {

    }

    @Override
    public void onClickButtonLeftActionbar() {

    }

    @Override
    public void onClickButtonRightActionbar() {

    }

    public void changeToFragmentSlideManager() {
        replaceFragment(new FragmentSlideManager(),true, Animation.SLIDE_IN_OUT);
    }

    public void changeToFragmentIntroduceManager() {
        replaceFragment(new FragmentIntroduceManager(),true, Animation.SLIDE_IN_OUT);
    }

    public void changeToFragmentChangePassManager() {
        replaceFragment(new FragmentChangePassManager(),true, Animation.SLIDE_IN_OUT);
    }
    public void changeToFragmentCompanyIntroduceDetail(CompanyModel data) {
        replaceFragment(FragmentCompanyIntroduceDetail.newInstance(data),true, Animation.SLIDE_IN_OUT);
    }
    ///////////////////////////////////////////////////////////////////////////
    // END
    ///////////////////////////////////////////////////////////////////////////

    public void doLogout() {
        showConfirmAlert("Cảnh báo", "Bạn có muốn đăng xuất tài khoản?", "Từ chối", "Đồng ý", Dialog::dismiss, kAlertDialog -> {
            kAlertDialog.dismiss();
            AppProvider.getPreferences().clear();
            AppProvider.getPreferences().saveUserModel(null);
            AppProvider.getPreferences().saveStatusLogin(false);
            AppProvider.getPreferences().saveFirstInstall(false);
            Intent intent = new Intent(AdminActivity.this, CustomerActivity.class);
            startActivity(intent);
            finish();
        }, KAlertDialog.WARNING_TYPE);
    }

    public void showConfirmAlert(String title, String mess, String titleButtonConfirm, String titleButtonCancel, KAlertDialog.KAlertClickListener actionConfirm, KAlertDialog.KAlertClickListener actionCancel, int type) {

        switch (type) {
            case KAlertDialog.SUCCESS_TYPE:
                showCustomerImageAndBgButtonConfirmAlert(title, mess, titleButtonConfirm, R.drawable.alert_dialog_button_confirm_bg_custom, titleButtonCancel, R.drawable.alert_dialog_button_cancel_bg_custom, actionConfirm, actionCancel, R.drawable.ic_img_alert_success);
                break;
            case KAlertDialog.WARNING_TYPE:
                showCustomerImageAndBgButtonConfirmAlert(title, mess, titleButtonConfirm, R.drawable.alert_dialog_button_cancel_bg_custom, titleButtonCancel, R.drawable.alert_dialog_button_confirm_bg_custom, actionConfirm, actionCancel, R.drawable.ic_img_alert_warning);
                break;
            case -1:
                showCustomerImageAndBgButtonConfirmAlert(title, mess, titleButtonConfirm, R.drawable.alert_dialog_button_confirm_bg_custom, titleButtonCancel, R.drawable.alert_dialog_button_cancel_bg_custom, actionConfirm, actionCancel, R.drawable.ic_img_alert_warning_logout);
                break;
        }

    }
}
