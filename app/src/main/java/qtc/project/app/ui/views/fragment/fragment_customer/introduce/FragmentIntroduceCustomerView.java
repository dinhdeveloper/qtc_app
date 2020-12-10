package qtc.project.app.ui.views.fragment.fragment_customer.introduce;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.customer.AboutUsModel;

public class FragmentIntroduceCustomerView extends BaseView<FragmentIntroduceCustomerView.UIContainer> implements FragmentIntroduceCustomerViewInterface {
    CustomerActivity activity;
    FragmentIntroduceCustomerViewCallback callback;

    @Override
    public void init(CustomerActivity activity, FragmentIntroduceCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.tvTitleHeader.setText("Giới thiệu");
    }

    @Override
    public void setDataAboutUs(AboutUsModel[] data) {
        if (data != null && data.length > 0) {
            AboutUsModel model = data[0];
            if (!TextUtils.isEmpty(model.getAbout_title())) {
                ui.tvCompany.setText(model.getAbout_title());
            }
            if (!TextUtils.isEmpty(model.getAbout_content())) {
                ui.tvDescription.setText(model.getAbout_content());
            }
            AppProvider.getImageHelper().displayImage(Consts.HOST_API + model.getImg_370_530(), ui.imvLogoCompany, null, R.drawable.no_image_full);
        }
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentIntroduceCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_introduce_customer;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.tvCompany)
        public TextView tvCompany;

        @UiElement(R.id.tvDescription)
        public TextView tvDescription;

        @UiElement(R.id.imvLogoCompany)
        public ImageView imvLogoCompany;

    }
}
