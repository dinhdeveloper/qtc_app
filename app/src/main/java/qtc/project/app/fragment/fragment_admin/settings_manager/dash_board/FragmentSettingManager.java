package qtc.project.app.fragment.fragment_admin.settings_manager.dash_board;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.dash_board.FragmentSettingManagerView;
import qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.dash_board.FragmentSettingManagerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.dash_board.FragmentSettingManagerViewInterface;

public class FragmentSettingManager extends BaseFragment<FragmentSettingManagerViewInterface, BaseParameters> implements FragmentSettingManagerViewCallback {
    AdminActivity activity;

    @Override
    protected void initialize() {
        activity = (AdminActivity) getActivity();
        view.init(activity, this);
    }

    @Override
    public void onBackHeader() {
        if (activity != null)
            activity.checkBack();
    }

    @Override
    public void changeToLogout() {
        if (activity!=null)
            activity.doLogout();
    }

    @Override
    public void changeToFragmentChangePassManager() {
        if (activity!=null)
            activity.changeToFragmentChangePassManager();
    }

    @Override
    protected FragmentSettingManagerViewInterface getViewInstance() {
        return new FragmentSettingManagerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
