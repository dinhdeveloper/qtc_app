package qtc.project.app.ui.views.fragment.fragment_admin.website_manager.slide_home;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import qtc.project.app.R;
import qtc.project.app.activity.AdminActivity;

public class FragmentSlideManagerView extends BaseView<FragmentSlideManagerView.UIContainer> implements FragmentSlideManagerViewInterface{
    AdminActivity activity;
    FragmentSlideManagerViewCallback callback;

    @Override
    public void init(AdminActivity activity, FragmentSlideManagerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }
    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentSlideManagerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_slide_manager;
    }


    public class UIContainer extends BaseUiContainer {
    }
}
