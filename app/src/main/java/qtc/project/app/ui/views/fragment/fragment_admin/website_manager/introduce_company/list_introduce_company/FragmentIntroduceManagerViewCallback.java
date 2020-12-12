package qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.list_introduce_company;

import qtc.project.app.model.customer.CompanyModel;

public interface FragmentIntroduceManagerViewCallback {

    void onBackHeader();

    void onCompanyIntroduceDetail(CompanyModel datum);
}
