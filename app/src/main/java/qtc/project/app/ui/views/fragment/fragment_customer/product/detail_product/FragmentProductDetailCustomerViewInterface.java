package qtc.project.app.ui.views.fragment.fragment_customer.product.detail_product;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.customer.ProductDetailModel;

public interface FragmentProductDetailCustomerViewInterface extends BaseViewInterface {
    void init(CustomerActivity activity,FragmentProductDetailCustomerViewCallback callback);

    void setDataProductDetail(ProductDetailModel[] data);
}
