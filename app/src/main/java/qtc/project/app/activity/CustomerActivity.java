package qtc.project.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import b.laixuantam.myaarlibrary.base.BaseFragmentActivity;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.OnKeyboardVisibilityListener;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.fragment.fragment_customer.acticles.FragmentArticleCustomer;
import qtc.project.app.fragment.fragment_customer.acticles.FragmentNewsDetailCustomer;
import qtc.project.app.fragment.fragment_customer.contacts.FragmentContactCustomer;
import qtc.project.app.fragment.fragment_customer.dashboard.FragmentDashboardCustomer;
import qtc.project.app.fragment.fragment_customer.introduce.FragmentIntroduceCustomer;
import qtc.project.app.fragment.fragment_customer.login.FragmentLoginCustomer;
import qtc.project.app.fragment.fragment_customer.product.FragmentProductCustomer;
import qtc.project.app.fragment.fragment_customer.product.FragmentProductDetailCustomer;
import qtc.project.app.model.UserResponseModel;
import qtc.project.app.model.customer.NewsModel;
import qtc.project.app.model.customer.ProductHomeModel;
import qtc.project.app.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewCallback;
import qtc.project.app.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewInterface;
import qtc.project.app.ui.views.activity.customer_activity.CustomerActivityView;
import qtc.project.app.ui.views.activity.customer_activity.CustomerActivityViewCallback;
import qtc.project.app.ui.views.activity.customer_activity.CustomerActivityViewInterface;

public class CustomerActivity extends BaseFragmentActivity<CustomerActivityViewInterface, BaseMainActionbarViewInterface, BaseParameters> implements BaseMainActionbarViewCallback, CustomerActivityViewCallback, ActivityCompat.OnRequestPermissionsResultCallback, OnKeyboardVisibilityListener {
    CustomerActivity activity;
    private int isShowContainer = 0;

    @Override
    protected void initialize(Bundle savedInstanceState) {
        activity = CustomerActivity.this;
        view.init(activity, this);

        UserResponseModel model = AppProvider.getPreferences().getUserModel();
        if (model != null) {
            if (!TextUtils.isEmpty(model.getLogin_level()) && model.getLogin_level().equalsIgnoreCase("2")) {
                startActivity(new Intent(CustomerActivity.this,AdminActivity.class));
                finish();
            }
        } else {
            changeToFragmentDashboard();
        }
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
                view.showBottomMenuBar();
            }

        } else {
            view.showBottomMenuBar();
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
    public void changeToFragmentDashboard() {
        isShowContainer = 0;
        showBottomMenuBar();
        replaceFragment(new FragmentDashboardCustomer(), false);
    }

    @Override
    public void changeToFragmentIntroduce() {
        isShowContainer++;
        showBottomMenuBar();
        replaceFragment(new FragmentIntroduceCustomer(), false);
    }

    @Override
    public void changeToFragmentProduct() {
        isShowContainer++;
        showBottomMenuBar();
        replaceFragment(new FragmentProductCustomer(), false);
    }

    @Override
    public void changeToFragmentArticle() {
        isShowContainer++;
        showBottomMenuBar();
        replaceFragment(new FragmentArticleCustomer(), false);
    }

    @Override
    public void changeToFragmentContact() {
        isShowContainer++;
        showBottomMenuBar();
        replaceFragment(new FragmentContactCustomer(), false);
    }

    public void showBottomMenuBar() {
        if (view != null)
            view.showBottomMenuBar();
    }

    public void hideBottomMenuBar() {
        if (view != null)
            view.hideBottomMenuBar();
    }

    @Override
    protected CustomerActivityViewInterface getViewInstance() {
        return new CustomerActivityView();
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
        return R.id.LayoutBaseMainFragmentActivity;
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

    public void changeToFragmentLogin() {
        isShowContainer++;
        activity.hideBottomMenuBar();
        replaceFragment(new FragmentLoginCustomer(), true, Animation.SLIDE_IN_OUT);
    }

    public void changeToFragmentProductDetail(ProductHomeModel model) {
        addFragment(FragmentProductDetailCustomer.newInstance(model), true, Animation.SLIDE_IN_OUT);
    }

    public void changeToFragmentNewsDetail(NewsModel model) {
        addFragment(FragmentNewsDetailCustomer.newInstance(model), true, Animation.SLIDE_IN_OUT);
    }

    public void goToHome() {
        switch (AppProvider.getPreferences().getUserModel().getLogin_level()) {
            case "2":
                startActivity(new Intent(CustomerActivity.this, AdminActivity.class));
                finish();
                break;
            default:
                showAlert("Bạn không có quyền vào ứng dụng", KAlertDialog.ERROR_TYPE);
        }
    }
}
