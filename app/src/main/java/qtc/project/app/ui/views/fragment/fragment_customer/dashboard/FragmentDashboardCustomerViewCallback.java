package qtc.project.app.ui.views.fragment.fragment_customer.dashboard;

import qtc.project.app.dialog.option.OptionModel;

public interface FragmentDashboardCustomerViewCallback {
    void refreshLoadingList();

    void onRequestLoadMoreList();

    void onRequestSearchWithFilter(String status, String key);

    void onItemListSelected(OptionModel item);

    void onClickAddItem();

    void onDeleteItemSelected(OptionModel item);

    void onClickFilter();
}
