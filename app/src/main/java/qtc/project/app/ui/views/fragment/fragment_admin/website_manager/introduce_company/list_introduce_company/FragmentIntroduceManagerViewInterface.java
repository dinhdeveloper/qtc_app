package qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.list_introduce_company;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.model.customer.CompanyModel;

public interface FragmentIntroduceManagerViewInterface extends BaseViewInterface {

    void init(AdminActivity activity,FragmentIntroduceManagerViewCallback callback);

    void setDataList(CompanyModel[] data);
}
