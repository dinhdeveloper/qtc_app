package qtc.project.app.ui.views.fragment.fragment_customer.contacts;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.customer.ContactModel;

public interface FragmentContactCustomerViewInterface extends BaseViewInterface {
    void init(CustomerActivity activity,FragmentContactCustomerViewCallback callback);

    void setDataContact(ContactModel[] data);
}
