package qtc.project.app.ui.views.activity.customer_activity;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;

public class CustomerActivityView extends BaseView<CustomerActivityView.UIContainer> implements CustomerActivityViewInterface {
    CustomerActivity activity;
    CustomerActivityViewCallback callback;

    @Override
    public void init(CustomerActivity activity, CustomerActivityViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new CustomerActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_activity_customer;
    }

    public class UIContainer extends BaseUiContainer {
    }
}
