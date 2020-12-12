package qtc.project.app.fragment.fragment_admin.website_manager.slide_home;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.slide_home.FragmentSlideManagerView;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.slide_home.FragmentSlideManagerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.slide_home.FragmentSlideManagerViewInterface;

public class FragmentSlideManager extends BaseFragment<FragmentSlideManagerViewInterface, BaseParameters> implements FragmentSlideManagerViewCallback {

    AdminActivity activity;

    @Override
    protected void initialize() {
        activity = (AdminActivity) getActivity();
        view.init(activity, this);
    }

    @Override
    protected FragmentSlideManagerViewInterface getViewInstance() {
        return new FragmentSlideManagerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
