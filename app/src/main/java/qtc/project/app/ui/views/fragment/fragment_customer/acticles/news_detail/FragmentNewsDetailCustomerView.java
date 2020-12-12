package qtc.project.app.ui.views.fragment.fragment_customer.acticles.news_detail;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.adapter.customer.ListPhotoProductAdapter;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.helper.Consts;
import qtc.project.app.helper.PredicateLayout;
import qtc.project.app.model.customer.HashTagModel;
import qtc.project.app.model.customer.NewsDetailModel;
import qtc.project.app.model.customer.NewsModel;
import qtc.project.app.model.customer.PhotoModel;

public class FragmentNewsDetailCustomerView extends BaseView<FragmentNewsDetailCustomerView.UIContainer> implements FragmentNewsDetailCustomerViewInterface {
    CustomerActivity activity;
    FragmentNewsDetailCustomerViewCallback callback;

    @Override
    public void init(CustomerActivity activity, FragmentNewsDetailCustomerViewCallback callback) {
        this.activity = activity;
        this.callback = callback;
        ui.tvTitleHeader.setText("Chi tiết tin tức");
        setVisible(ui.btnBackHeader);
        ui.btnBackHeader.setOnClickListener(v -> {
            if (callback != null)
                callback.onBackHeader();
        });
    }

    boolean checkStatus = true;
    private final List<HashTagModel> listHotkey = new ArrayList<>();

    @Override
    public void setDataNews(NewsDetailModel[] dataNews) {
        if (dataNews != null) {
            NewsDetailModel model = dataNews[0];
            AppProvider.getImageHelper().displayImage(Consts.HOST_API + model.getThumb_800_300(), ui.imvProductAvata, null, R.drawable.no_image_full);
            List<PhotoModel> photoModels = new ArrayList<>();
            if (model.getImg_photo() != null) {
                photoModels.addAll(Arrays.asList(model.getImg_photo()));
            }
            ListPhotoProductAdapter photoProductAdapter = new ListPhotoProductAdapter(activity, photoModels);
            ui.recycler_view_list_product_photo.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
            ui.recycler_view_list_product_photo.setAdapter(photoProductAdapter);
            photoProductAdapter.notifyDataSetChanged();
            photoProductAdapter.setListener(model1 -> {
                AppProvider.getImageHelper().displayImage(Consts.HOST_API + model1.getImg_photo(), ui.imvProductAvata, null, R.drawable.no_image_full);
            });
            if (!TextUtils.isEmpty(model.getNews_content())) {
                ui.tvDescription.setText(model.getNews_content());
            }
            ui.imvLoadMore.setOnClickListener(v -> {
                if (checkStatus) {
                    setGone(ui.tvDescription);
                    ui.imvLoadMore.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    checkStatus = false;
                } else {
                    setVisible(ui.tvDescription);
                    ui.imvLoadMore.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    checkStatus = true;
                }
            });

            //hashtag
            if (model.getTag_title() != null) {
                LayoutInflater inflater = activity.getLayoutInflater();
                for (HashTagModel item : model.getTag_title()) {
                    listHotkey.add(item);
                    @SuppressLint("InflateParams") View keypadLayout = inflater.inflate(R.layout.row_item_hot_key, null);
                    keypadLayout.setLayoutParams(new LinearLayout.LayoutParams(20, 10));

                    TextView textValue = keypadLayout.findViewById(R.id.tvHashTags);
                    textValue.setText("#" + item.getTag_title());

                    textValue.setTag(listHotkey.size() - 1);
                    ui.predicate_layout_hot_key.addView(keypadLayout);
                }
            }
        }
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new FragmentNewsDetailCustomerView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_fragment_acticle_detail_customer;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.layoutRootView)
        public View layoutRootView;

        @UiElement(R.id.tvTitleHeader)
        public TextView tvTitleHeader;

        @UiElement(R.id.btnBackHeader)
        public ImageView btnBackHeader;

        @UiElement(R.id.imvProductAvata)
        public ImageView imvProductAvata;

        @UiElement(R.id.imvLoadMore)
        public ImageView imvLoadMore;

        @UiElement(R.id.tvDescription)
        public TextView tvDescription;

        @UiElement(R.id.predicate_layout_hot_key)
        public PredicateLayout predicate_layout_hot_key;

        @UiElement(R.id.recycler_view_list_product_photo)
        public RecyclerView recycler_view_list_product_photo;
    }
}
