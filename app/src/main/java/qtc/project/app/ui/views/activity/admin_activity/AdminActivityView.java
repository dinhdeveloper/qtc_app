package qtc.project.app.ui.views.activity.admin_activity;

import android.widget.ImageView;
import android.widget.TextView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundLinearLayout;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundTextView;
import qtc.project.app.R;
import qtc.project.app.activity.AdminActivity;

public class AdminActivityView extends BaseView<AdminActivityView.UIContainer> implements AdminActivityViewInterface {
    AdminActivity activity;
    AdminActivityViewCallback callback;
    int positionSlected = -1;

    @Override
    public void init(AdminActivity activity, AdminActivityViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        ui.imvAction1.setOnClickListener(v -> {
            setVisible(ui.tvAction1);
            setGone(ui.tvAction2);
            setGone(ui.tvAction3);
            setGone(ui.tvAction4);
            positionSlected = 0;

        });
        ui.imvAction2.setOnClickListener(v -> {
            setVisible(ui.tvAction2);
            setGone(ui.tvAction1);
            setGone(ui.tvAction3);
            setGone(ui.tvAction4);
            positionSlected = 1;

        });
        ui.imvAction3.setOnClickListener(v -> {
            setVisible(ui.tvAction3);
            setGone(ui.tvAction2);
            setGone(ui.tvAction1);
            setGone(ui.tvAction4);
            positionSlected = 2;

        });
        ui.imvAction4.setOnClickListener(v -> {
            setVisible(ui.tvAction4);
            setGone(ui.tvAction2);
            setGone(ui.tvAction3);
            setGone(ui.tvAction1);
            positionSlected = 3;

        });

        ui.btnSubmit.setOnClickListener(v -> {
            switch (positionSlected) {
                case 0:
                    if (callback != null)
                        callback.changeToFragmentWebsiteManager();
                    break;
                case 1:
                    if (callback != null)
                        callback.changeToFragmentNewsManager();
                    break;
                case 2:
                    if (callback != null)
                        callback.changeToFragmentProductManager();
                    break;
                case 3:
                    if (callback != null)
                        callback.changeToFragmentSettingsManager();
                    break;

            }
        });
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new AdminActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_activity_admin;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.imvAction1)
        public ImageView imvAction1;

        @UiElement(R.id.imvAction2)
        public ImageView imvAction2;

        @UiElement(R.id.imvAction3)
        public ImageView imvAction3;

        @UiElement(R.id.imvAction4)
        public ImageView imvAction4;

        @UiElement(R.id.tvAction1)
        public TextView tvAction1;

        @UiElement(R.id.tvAction2)
        public TextView tvAction2;

        @UiElement(R.id.tvAction3)
        public TextView tvAction3;

        @UiElement(R.id.tvAction4)
        public TextView tvAction4;

        @UiElement(R.id.btnSubmit)
        public RoundLinearLayout btnSubmit;

    }
}
