package qtc.project.app.ui.views.fragment.fragment_customer.product.detail_product;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.customer.ProductDetailModel;

public class FragmentProductDetailCustomerView extends BaseView<FragmentProductDetailCustomerView.UIContainer> implements FragmentProductDetailCustomerViewInterface{

    CustomerActivity activity;
    FragmentProductDetailCustomerViewCallback callback;

    @Override
    public void init(CustomerActivity activity, FragmentProductDetailCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

        ui.tvTitleHeader.setText("Chi tiết sản phẩm");
        ui.btnBackHeader.setVisibility(View.VISIBLE);
        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback!=null)
                callback.onBackHeader();
        });
    }

    @Override
    public void setDataProductDetail(ProductDetailModel[] data) {

    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentProductDetailCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_product_detail;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.layoutRootView)
        public View layoutRootView;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;



    }
}
