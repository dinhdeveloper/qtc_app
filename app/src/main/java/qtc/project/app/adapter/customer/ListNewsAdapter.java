package qtc.project.app.adapter.customer;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import b.laixuantam.myaarlibrary.widgets.roundview.RoundRelativeLayout;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import b.laixuantam.myaarlibrary.widgets.ultils.ConvertDate;
import qtc.project.app.R;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.customer.NewsModel;

public class ListNewsAdapter extends SuperAdapter<OptionModel> {
    ListNewsListener listener;

    public interface ListNewsListener {
        void onClickItem(OptionModel model);
    }

    public void setListener(ListNewsListener listener) {
        this.listener = listener;
    }

    public ListNewsAdapter(Context context, List<OptionModel> items) {
        super(context, items, R.layout.custom_item_category_detail);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, OptionModel item) {
        RoundRelativeLayout layoutItemProductDetail = holder.findViewById(R.id.layoutItemProductDetail);
        ImageView imvProductAvata = holder.findViewById(R.id.imvProductAvata);
        TextView tvCategoryName = holder.findViewById(R.id.tvCategoryName);
        TextView tvDateCreate = holder.findViewById(R.id.tvDateCreate);

        NewsModel model = (NewsModel) item.getDtaCustom();
        AppProvider.getImageHelper().displayImage(Consts.HOST_API + model.getThumb_800_300(), imvProductAvata, null, R.drawable.no_image_full);
        if (!TextUtils.isEmpty(model.getUpload_date())) {
            tvDateCreate.setText(ConvertDate.changeToNiceFormatDate(model.getUpload_date()));
        }
        if (!TextUtils.isEmpty(model.getNews_title())) {
            tvCategoryName.setText(model.getNews_title());
        }
        layoutItemProductDetail.setOnClickListener(v -> {
            if (listener != null)
                listener.onClickItem(item);
        });
    }
}
