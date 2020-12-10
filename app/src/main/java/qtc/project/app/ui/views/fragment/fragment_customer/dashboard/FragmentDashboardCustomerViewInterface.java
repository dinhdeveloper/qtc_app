package qtc.project.app.ui.views.fragment.fragment_customer.dashboard;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ImageSlideModel;
import qtc.project.app.model.customer.ProductHomeModel;

public interface FragmentDashboardCustomerViewInterface extends BaseViewInterface {

    void init(CustomerActivity activity,FragmentDashboardCustomerViewCallback callback);

    void setDataImageSlide(ImageSlideModel[] data);

    void showEmptyList();

    void hideEmptyList();

    void setDataList(BaseResponseModel dataList);

    void setNoMoreLoading();

    void resetListData();

    void hideRootView();

    void showRootView();

    void clearListData();
}
