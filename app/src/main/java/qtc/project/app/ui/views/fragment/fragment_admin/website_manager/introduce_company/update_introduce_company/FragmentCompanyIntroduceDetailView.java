package qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.update_introduce_company;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import qtc.project.app.activity.AdminActivity;

public class FragmentCompanyIntroduceDetailView extends BaseView<FragmentCompanyIntroduceDetailView.UIContainer> implements FragmentCompanyIntroduceDetailViewInterface {
    AdminActivity activity;
    FragmentCompanyIntroduceDetailViewCallback callback;

    @Override
    public void init(AdminActivity activity, FragmentCompanyIntroduceDetailViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentCompanyIntroduceDetailView.UIContainer();
    }

    @Override
    public int getViewId() {
        return 0;
    }

    public class UIContainer extends BaseUiContainer {
    }
}
