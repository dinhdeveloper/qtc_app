package qtc.project.app.ui.views.fragment.fragment_customer.product.list_product;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.CategoryProductModel;

public interface FragmentProductCustomerViewInterface extends BaseViewInterface {

    void init(CustomerActivity activity,FragmentProductCustomerViewCallback callback);

    void setDataCategoryProduct(CategoryProductModel[] data);
    void showEmptyList();

    void hideEmptyList();

    void setDataList(BaseResponseModel dataList);

    void setNoMoreLoading();

    void resetListData();

    void hideRootView();

    void showRootView();

    void clearListData();
}
