package qtc.project.app.ui.views.fragment.fragment_admin.website_manager.introduce_company.list_introduce_company;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundRelativeLayout;
import b.laixuantam.myaarlibrary.widgets.roundview.RoundTextView;
import qtc.project.app.R;
import qtc.project.app.activity.AdminActivity;
import qtc.project.app.model.customer.CompanyModel;

public class FragmentIntroduceManagerView extends BaseView<FragmentIntroduceManagerView.UIContainer> implements FragmentIntroduceManagerViewInterface {
    AdminActivity activity;
    FragmentIntroduceManagerViewCallback callback;

    @Override
    public void init(AdminActivity activity, FragmentIntroduceManagerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        setVisible(ui.btnBackHeader);
        ui.tvTitleHeader.setText("Giới thiệu công ty");
        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback != null)
                callback.onBackHeader();
        });

//        ui.btnSubmit.setOnClickListener(v -> {
//            CompanyModel model = new CompanyModel();
//
//            if (!TextUtils.isEmpty(ui.edtTitle.getText().toString())) {
//                model.setAbout_title(ui.edtTitle.getText().toString());
//            }
//            if (!TextUtils.isEmpty(ui.edtDescription.getText().toString())) {
//                model.setAbout_content(ui.edtDescription.getText().toString());
//            }
//
//            if (callback != null)
//                callback.updateIntroduceCompany(model);
//        });
    }

    @Override
    public void setDataList(CompanyModel[] data) {
        if (data != null && data.length > 0) {
            if (data[0] != null) {
                setGone(ui.layout_empty);
                if (!TextUtils.isEmpty(data[0].getAbout_title())){
                    ui.tvSupplierName.setText(data[0].getAbout_title());
                }
                if (!TextUtils.isEmpty(data[0].getAbout_content())){
                    ui.tvSupplierDescription.setText(data[0].getAbout_content());
                }
                ui.rowItem.setOnClickListener(v -> {
                    if (callback!=null)
                        callback.onCompanyIntroduceDetail(data[0]);
                });
            } else {
                setVisible(ui.layout_empty);
            }
        }
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentIntroduceManagerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_introduce_admin;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.recycler_view_list)
        public RecyclerView recycler_view_list;

        @UiElement(R.id.edtTitle)
        public EditText edtTitle;

        @UiElement(R.id.edtDescription)
        public EditText edtDescription;

        @UiElement(R.id.btnSubmit)
        public RoundTextView btnSubmit;

        @UiElement(R.id.layout_item)
        public RelativeLayout layout_item;

        @UiElement(R.id.layout_empty)
        public RelativeLayout layout_empty;


        @UiElement(R.id.rowItem)
        public RoundRelativeLayout rowItem;

        @UiElement(R.id.tvSupplierName)
        public TextView tvSupplierName;

        @UiElement(R.id.tvSupplierDescription)
        public TextView tvSupplierDescription;

    }
}
