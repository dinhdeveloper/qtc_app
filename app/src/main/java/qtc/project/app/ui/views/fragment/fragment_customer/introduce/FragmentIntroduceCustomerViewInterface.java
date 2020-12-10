package qtc.project.app.ui.views.fragment.fragment_customer.introduce;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.customer.AboutUsModel;

public interface FragmentIntroduceCustomerViewInterface extends BaseViewInterface {

    void init(CustomerActivity activity, FragmentIntroduceCustomerViewCallback callback);

    void setDataAboutUs(AboutUsModel[] data);
}
