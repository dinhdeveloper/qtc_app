package qtc.project.app.ui.views.activity.customer_activity;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;

public interface CustomerActivityViewInterface extends BaseViewInterface {

    void init(CustomerActivity activity,CustomerActivityViewCallback callback);
}
