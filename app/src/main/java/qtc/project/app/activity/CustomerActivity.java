package qtc.project.app.activity;

import android.os.Bundle;

import androidx.core.app.ActivityCompat;

import b.laixuantam.myaarlibrary.base.BaseFragmentActivity;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.OnKeyboardVisibilityListener;
import qtc.project.app.R;
import qtc.project.app.fragment.fragment_customer.acticles.FragmentArticleCustomer;
import qtc.project.app.fragment.fragment_customer.contacts.FragmentContactCustomer;
import qtc.project.app.fragment.fragment_customer.dashboard.FragmentDashboardCustomer;
import qtc.project.app.fragment.fragment_customer.introduce.FragmentIntroduceCustomer;
import qtc.project.app.fragment.fragment_customer.login.FragmentLoginCustomer;
import qtc.project.app.fragment.fragment_customer.product.FragmentProductCustomer;
import qtc.project.app.fragment.fragment_customer.product.FragmentProductDetailCustomer;
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
        changeToFragmentDashboard();
    }

    @Override
    public void changeToFragmentDashboard() {
        isShowContainer = 0;
        showBottomMenuBar();
        replaceFragment(new FragmentDashboardCustomer(), false);
    }

    @Override
    public void changeToFragmentIntroduce() {
        isShowContainer ++;
        showBottomMenuBar();
        replaceFragment(new FragmentIntroduceCustomer(), false);
    }

    @Override
    public void changeToFragmentProduct() {
        isShowContainer ++;
        showBottomMenuBar();
        replaceFragment(new FragmentProductCustomer(), false);
    }

    @Override
    public void changeToFragmentArticle() {
        isShowContainer ++;
        showBottomMenuBar();
        replaceFragment(new FragmentArticleCustomer(), false);
    }

    @Override
    public void changeToFragmentContact() {
        isShowContainer ++;
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
        isShowContainer ++;
        activity.hideBottomMenuBar();
        replaceFragment(new FragmentLoginCustomer(),true,Animation.SLIDE_IN_OUT);
    }

    public void changeToFragmentProductDetail(ProductHomeModel model) {
        addFragment(FragmentProductDetailCustomer.newInstance(model),true,Animation.SLIDE_IN_OUT);
    }
}
