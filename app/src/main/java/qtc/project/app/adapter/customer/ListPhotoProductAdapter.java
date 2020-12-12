package qtc.project.app.adapter.customer;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import java.util.List;

import b.laixuantam.myaarlibrary.widgets.superadapter.SuperAdapter;
import b.laixuantam.myaarlibrary.widgets.superadapter.SuperViewHolder;
import qtc.project.app.R;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.customer.PhotoModel;

public class ListPhotoProductAdapter extends SuperAdapter<PhotoModel> {
    ListPhotoProductListener listener;

    public interface ListPhotoProductListener {
        void onClickImage(PhotoModel model);
    }

    public void setListener(ListPhotoProductListener listener) {
        this.listener = listener;
    }

    public ListPhotoProductAdapter(Context context, List<PhotoModel> items) {
        super(context, items, R.layout.layout_item_photo);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, PhotoModel item) {
        ImageView imvPhoto = holder.findViewById(R.id.imvPhoto);
        if (!TextUtils.isEmpty(item.getImg_370_530())) {
            AppProvider.getImageHelper().displayImage(Consts.HOST_API + item.getImg_370_530(), imvPhoto, null, R.drawable.no_image_full);
        }

        if (!TextUtils.isEmpty(item.getImg_photo())) {
            AppProvider.getImageHelper().displayImage(Consts.HOST_API + item.getImg_photo(), imvPhoto, null, R.drawable.no_image_full);
        }

        imvPhoto.setOnClickListener(v -> {
            if (listener != null)
                listener.onClickImage(item);
        });
    }
}
