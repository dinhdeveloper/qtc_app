package qtc.project.app.ui.views.fragment.fragment_customer.acticles.news_detail;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.model.customer.NewsDetailModel;
import qtc.project.app.model.customer.NewsModel;

public interface FragmentNewsDetailCustomerViewInterface extends BaseViewInterface {

    void init(CustomerActivity activity,FragmentNewsDetailCustomerViewCallback callback);

    void setDataNews(NewsDetailModel[] model);
}
