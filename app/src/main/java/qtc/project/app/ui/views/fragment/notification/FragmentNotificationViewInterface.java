package qtc.project.app.ui.views.fragment.notification;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.HomeActivity;
import qtc.project.app.model.NotificationModel;

public interface FragmentNotificationViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentNotificationViewCallback callback);

    void setDataNotification(NotificationModel[] data);

    void setNoMoreLoading();

    void validateCheckSeenNotifySuccess();

    void hideRootView();

    void showRootView();
}
