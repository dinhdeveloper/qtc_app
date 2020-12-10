package qtc.project.app.ui.views.fragment.account.password_manager;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.HomeActivity;

public interface FragmentPasswordManagerViewInterface extends BaseViewInterface {
    void init(HomeActivity activity, FragmentPasswordManagerViewCallback callback);

    void validateUpdatePasswordSuccess();
}
