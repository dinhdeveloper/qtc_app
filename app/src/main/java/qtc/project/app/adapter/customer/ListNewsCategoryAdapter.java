package qtc.project.app.adapter.customer;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import qtc.project.app.R;
import qtc.project.app.model.customer.NewsCategoryModel;

public class ListNewsCategoryAdapter extends SuperAdapter<NewsCategoryModel> {
    ListNewsCategoryListener listener;
    Context context;
    boolean checkClick = true;

    public interface ListNewsCategoryListener {
        void onClickItem(NewsCategoryModel model);
    }

    public void setListener(ListNewsCategoryListener listener) {
        this.listener = listener;
    }

    public ListNewsCategoryAdapter(Context context, List<NewsCategoryModel> items) {
        super(context, items, R.layout.custom_item_category);
        this.context = context;
    }

    int row_index = 0;

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, NewsCategoryModel item) {
        LinearLayout layout_item = holder.findViewById(R.id.layout_item);
        TextView tvCategoryName = holder.findViewById(R.id.tvCategoryName);
        final int sdk = android.os.Build.VERSION.SDK_INT;

        if (!TextUtils.isEmpty(item.getCategory_title())) {
            tvCategoryName.setText(item.getCategory_title());
        }
        layout_item.setOnClickListener(v -> {
            row_index = layoutPosition;
            notifyDataSetChanged();
        });

        if (row_index == layoutPosition) {
            tvCategoryName.setTextColor(Color.parseColor("#FFFFFF"));
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                layout_item.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_color_gradient));
            } else {
                layout_item.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_color_gradient));
            }
            if (listener != null)
                listener.onClickItem(item);
        } else {
            tvCategoryName.setTextColor(Color.parseColor("#000000"));
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                layout_item.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_color_bg_item));
            } else {
                layout_item.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_color_bg_item));
            }
        }
    }
}

