package qtc.project.app.ui.views.activity.customer_activity;

import android.view.View;
import android.widget.FrameLayout;

import com.simform.custombottomnavigation.SSCustomBottomNavigation;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.widgets.bottomnavigationbar.BottomNavigationBar;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;

public class CustomerActivityView extends BaseView<CustomerActivityView.UIContainer> implements CustomerActivityViewInterface {
    CustomerActivity activity;
    CustomerActivityViewCallback callback;

    @Override
    public void init(CustomerActivity activity, CustomerActivityViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        configSSCustomBottomNavigation();
    }

    private void configSSCustomBottomNavigation() {
        //https://github.com/SimformSolutionsPvtLtd/SSCustomBottomNavigation

        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(1, R.drawable.ic_qtc_home_active, "Trang chủ"));
        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(2, R.drawable.ic_qtc_review, "Giới thiệu"));
        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(3, R.drawable.ic_qtc_product, "Sản phẩm"));
        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(4, R.drawable.ic_qtc_news, "Tin tức"));
        ui.layout_SSCustomBottomNavigation.add(new SSCustomBottomNavigation.Model(5, R.drawable.ic_qtc_contact, "Liên hệ"));

        ui.layout_SSCustomBottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
                    if (callback!=null)
                        callback.changeToFragmentDashboard();
                    break;
                case 2:
                   if (callback!=null)
                        callback.changeToFragmentIntroduce();
                    break;
                case 3:
                    if (callback!=null)
                        callback.changeToFragmentProduct();
                    break;
                case 4:
                    if (callback!=null)
                        callback.changeToFragmentArticle();
                    break;
                case 5:
                    if (callback!=null)
                        callback.changeToFragmentContact();
                    break;
            }
            return null;
        });

        ui.layout_SSCustomBottomNavigation.show(1, true);
    }

    @Override
    public void showBottomMenuBar() {
        setVisible(ui.layoutBottomMenuHome);
    }

    @Override
    public void hideBottomMenuBar() {
        setGone(ui.layoutBottomMenuHome);
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new CustomerActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_activity_customer;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.LayoutBaseMainFragmentActivity)
        public FrameLayout LayoutBaseMainFragmentActivity;

        @UiElement(R.id.bnb_menu_control)
        public BottomNavigationBar bnb_menu_control;

        @UiElement(R.id.layoutBottomMenuHome)
        public View layoutBottomMenuHome;

        @UiElement(R.id.LayoutBaseMainActivity)
        public View LayoutBaseMainActivity;

        @UiElement(R.id.layout_SSCustomBottomNavigation)
        public SSCustomBottomNavigation layout_SSCustomBottomNavigation;
    }
}
