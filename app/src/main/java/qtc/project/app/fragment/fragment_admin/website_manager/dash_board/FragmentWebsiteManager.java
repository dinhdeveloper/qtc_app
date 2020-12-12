package qtc.project.app.fragment.fragment_admin.website_manager.dash_board;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseFragmentActivity;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.dash_board.FragmentWebsiteManagerView;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.dash_board.FragmentWebsiteManagerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.dash_board.FragmentWebsiteManagerViewInterface;

public class FragmentWebsiteManager extends BaseFragment<FragmentWebsiteManagerViewInterface, BaseParameters> implements FragmentWebsiteManagerViewCallback {
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
    public void changeToFragmentSlideManager() {
        if (activity!=null)
            activity.changeToFragmentSlideManager();
    }

    @Override
    public void changeToFragmentIntroduceManager() {
        if (activity!=null)
            activity.changeToFragmentIntroduceManager();
    }

    @Override
    protected FragmentWebsiteManagerViewInterface getViewInstance() {
        return new FragmentWebsiteManagerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
