package qtc.project.app.fragment.fragment_admin.website_manager.introduce_company;

import android.os.Bundle;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.model.customer.CompanyModel;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.update_introduce_company.FragmentCompanyIntroduceDetailView;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.update_introduce_company.FragmentCompanyIntroduceDetailViewCallback;
import qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.update_introduce_company.FragmentCompanyIntroduceDetailViewInterface;

public class FragmentCompanyIntroduceDetail extends BaseFragment<FragmentCompanyIntroduceDetailViewInterface, BaseParameters> implements FragmentCompanyIntroduceDetailViewCallback {
    AdminActivity activity;

    public static FragmentCompanyIntroduceDetail newInstance(CompanyModel model) {

        Bundle args = new Bundle();
        args.putSerializable("model", model);
        FragmentCompanyIntroduceDetail fragment = new FragmentCompanyIntroduceDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initialize() {
        activity = (AdminActivity) getActivity();
        view.init(activity, this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            CompanyModel model = (CompanyModel)bundle.getSerializable("model");
        }
    }

    @Override
    protected FragmentCompanyIntroduceDetailViewInterface getViewInstance() {
        return new FragmentCompanyIntroduceDetailView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }
}
