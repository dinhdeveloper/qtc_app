package qtc.project.app.ui.views.fragment.fragment_admin.website_manager.dash_board;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundLinearLayout;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundTextView;
import qtc.project.app.R;
import qtc.project.app.activity.AdminActivity;

public class FragmentWebsiteManagerView extends BaseView<FragmentWebsiteManagerView.UIContainer> implements FragmentWebsiteManagerViewInterface {
    AdminActivity activity;
    FragmentWebsiteManagerViewCallback callback;

    @Override
    public void init(AdminActivity activity, FragmentWebsiteManagerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.tvTitleHeader.setText("Quản lý website");
        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback != null)
                callback.onBackHeader();
        });

        ui.btnSubmit.setOnClickListener(v -> {
            if (checked) {
                if (callback != null)
                    callback.changeToFragmentIntroduceManager();
            } else {
                if (callback != null)
                    callback.changeToFragmentSlideManager();
            }
        });

        ui.btnOption2.setOnClickListener(v -> {
            checked = true;
            setGone(ui.btnOption2);
            setVisible(ui.btnOption3);
            ui.btnOption1.setText("Giới thiệu công ty");
            ui.btnOption3.setText("Quản lý home slide");
            ui.btnOption1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_qtc_gioi_thieu_cong_ty_active, 0, R.drawable.ic_qtc_tick_on, 0);
            ui.btnOption3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_quan_ly_slide_home, 0, R.drawable.ic_qtc_tick_off, 0);
        });
        ui.btnOption3.setOnClickListener(v -> {
            checked = false;
            setGone(ui.btnOption3);
            setVisible(ui.btnOption2);
            ui.btnOption1.setText("Quản lý home slide");
            ui.btnOption2.setText("Giới thiệu công ty");
            ui.btnOption1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_quan_ly_slide_home_active, 0, R.drawable.ic_qtc_tick_on, 0);
            ui.btnOption2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_qtc_gioi_thieu_cong_ty, 0, R.drawable.ic_qtc_tick_off, 0);
        });

    }

    boolean checked = false;

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentWebsiteManagerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_website_manager;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.btnOption1)
        public RoundTextView btnOption1;

        @UiElement(R.id.btnOption2)
        public RoundTextView btnOption2;

        @UiElement(R.id.btnOption3)
        public RoundTextView btnOption3;

        @UiElement(R.id.btnSubmit)
        public RoundLinearLayout btnSubmit;


    }
}
