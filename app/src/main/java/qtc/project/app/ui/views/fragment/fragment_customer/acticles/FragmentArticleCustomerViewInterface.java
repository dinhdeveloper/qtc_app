package qtc.project.app.ui.views.fragment.fragment_customer.acticles;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.CategoryProductModel;
import qtc.project.app.model.customer.NewsCategoryModel;
import qtc.project.app.model.customer.NewsModel;

public interface FragmentArticleCustomerViewInterface extends BaseViewInterface {

    void init(CustomerActivity activity,FragmentArticleCustomerViewCallback callback);

    void setDataNews(NewsCategoryModel[] data);
    void showEmptyList();

    void hideEmptyList();

    void setDataList(BaseResponseModel dataList);

    void setNoMoreLoading();

    void resetListData();

    void hideRootView();

    void showRootView();

    void clearListData();
}
