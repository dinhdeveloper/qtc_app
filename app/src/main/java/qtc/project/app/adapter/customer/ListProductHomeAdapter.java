package qtc.project.app.adapter.customer;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import b.laixuantam.myaarlibrary.widgets.roundview.RoundRelativeLayout;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import qtc.project.app.R;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.customer.ProductHomeModel;

public class ListProductHomeAdapter extends SuperAdapter<OptionModel> {
    ListProductHomeListener listener;

    public interface ListProductHomeListener {
        void onClickItem(OptionModel model);
    }

    public void setListener(ListProductHomeListener listener) {
        this.listener = listener;
    }

    public ListProductHomeAdapter(Context context, List<OptionModel> items) {
        super(context, items, R.layout.custom_item_product);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, OptionModel item) {
        RoundRelativeLayout layoutItemProductDetail = holder.findViewById(R.id.layoutItemProductDetail);
        ImageView imvProductAvatar = holder.findViewById(R.id.imvProductAvatar);
        ImageView imvPreview = holder.findViewById(R.id.imvPreview);
        TextView tvName = holder.findViewById(R.id.tvName);

        ProductHomeModel model = (ProductHomeModel) item.getDtaCustom();
        if (!TextUtils.isEmpty(model.getProduct_title())) {
            tvName.setText(model.getProduct_title());
        }

        AppProvider.getImageHelper().displayImage(Consts.HOST_API + model.getProduct_thumb(), imvProductAvatar, null, R.drawable.no_image_full);
        AppProvider.getImageHelper().displayImage(Consts.HOST_API + model.getProduct_icon(), imvPreview, null, R.drawable.no_image_full);

        layoutItemProductDetail.setOnClickListener(v -> {
            if (listener != null)
                listener.onClickItem(item);
        });
    }
}
