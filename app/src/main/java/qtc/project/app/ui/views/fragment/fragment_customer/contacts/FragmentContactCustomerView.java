package qtc.project.app.ui.views.fragment.fragment_customer.contacts;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.customer.ContactModel;

public class FragmentContactCustomerView extends BaseView<FragmentContactCustomerView.UIContainer> implements FragmentContactCustomerViewInterface {
    CustomerActivity activity;
    FragmentContactCustomerViewCallback callback;

    @Override
    public void init(CustomerActivity activity, FragmentContactCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.tvTitleHeader.setText("Liên hệ");
        setVisible(ui.imvAction2);

        ui.imvAction2.setOnClickListener(v -> {
            if (callback != null)
                callback.changeToFragmentLogin();
        });

    }

    @Override
    public void setDataContact(ContactModel[] data) {
        if (data != null && data.length > 0) {
            ContactModel model = data[0];
            if (!TextUtils.isEmpty(model.getTitle_company())) {
                ui.tvCompany.setText(model.getTitle_company());
            }
            if (!TextUtils.isEmpty(model.getAddress())) {
                ui.tvAddress.setText(model.getAddress());
            }
            if (!TextUtils.isEmpty(model.getHotline())) {
                ui.tvCall.setText(model.getHotline());
            }
            if (!TextUtils.isEmpty(model.getEmail())) {
                ui.tvMail.setText(model.getEmail());
            }
        }
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentContactCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_contact_customer;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.imvAction2)
        public ImageView imvAction2;

        @UiElement(R.id.tvCompany)
        public TextView tvCompany;

        @UiElement(R.id.tvAddress)
        public TextView tvAddress;


        @UiElement(R.id.tvCall)
        public TextView tvCall;

        @UiElement(R.id.tvMail)
        public TextView tvMail;

        @UiElement(R.id.btnFacebook)
        public CardView btnFacebook;

        @UiElement(R.id.btnYoutube)
        public CardView btnYoutube;
    }
}
