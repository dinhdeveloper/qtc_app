package qtc.project.app.ui.views.fragment.list_base;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.HomeActivity;
import qtc.project.app.model.BaseResponseModel;

public interface FragmentAdminManagerListBaseViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentAdminManagerListBaseViewCallback callback);

    void showEmptyList();

    void hideEmptyList();

    void setDataList(BaseResponseModel dataList);

    void setNoMoreLoading();

    void resetListData();

    void hideRootView();

    void showRootView();

    void clearListData();
}
