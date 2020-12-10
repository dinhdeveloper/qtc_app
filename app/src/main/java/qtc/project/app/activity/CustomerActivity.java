package qtc.project.app.activity;

import android.os.Bundle;

import androidx.core.app.ActivityCompat;

import b.laixuantam.myaarlibrary.base.BaseFragmentActivity;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.OnKeyboardVisibilityListener;
import qtc.project.app.R;
import qtc.project.app.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewCallback;
import qtc.project.app.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewInterface;
import qtc.project.app.ui.views.activity.customer_activity.CustomerActivityView;
import qtc.project.app.ui.views.activity.customer_activity.CustomerActivityViewCallback;
import qtc.project.app.ui.views.activity.customer_activity.CustomerActivityViewInterface;

public class CustomerActivity extends BaseFragmentActivity<CustomerActivityViewInterface, BaseMainActionbarViewInterface, BaseParameters> implements BaseMainActionbarViewCallback, CustomerActivityViewCallback, ActivityCompat.OnRequestPermissionsResultCallback, OnKeyboardVisibilityListener {
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
    protected void initialize(Bundle savedInstanceState) {

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
}
