package qtc.project.app.ui.views.fragment.fragment_customer.product.detail_product;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ProductDetailModel;
import qtc.project.app.model.customer.ProductHomeModel;

public interface FragmentProductDetailCustomerViewInterface extends BaseViewInterface {
    void init(CustomerActivity activity,FragmentProductDetailCustomerViewCallback callback);

    void setDataProductDetail(ProductDetailModel[] data);
    void resetListData();

    void hideRootView();

    void showRootView();

    void setDataList(BaseResponseModel result);
}
