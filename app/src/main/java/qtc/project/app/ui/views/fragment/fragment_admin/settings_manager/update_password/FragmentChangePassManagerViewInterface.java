package qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.update_password;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.AdminActivity;

public interface FragmentChangePassManagerViewInterface extends BaseViewInterface {

    void init(AdminActivity activity,FragmentChangePassManagerViewCallback callback);

    void clearData();
}
