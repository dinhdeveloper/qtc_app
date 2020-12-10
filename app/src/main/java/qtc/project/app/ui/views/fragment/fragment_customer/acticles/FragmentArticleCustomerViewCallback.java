package qtc.project.app.ui.views.fragment.fragment_customer.acticles;

import qtc.project.app.dialog.option.OptionModel;

public interface FragmentArticleCustomerViewCallback {

    void refreshLoadingList();

    void onRequestLoadMoreList();

    void onRequestSearchWithFilter(String status, String key);

    void onItemListSelected(OptionModel item);

    void onClickAddItem();

    void onDeleteItemSelected(OptionModel item);

    void onClickFilter();

    void onRequestNewDetail(String id);
}
