package qtc.project.app.fragment.fragment_customer.acticles;

import android.text.TextUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.ErrorApiResponse;
import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import qtc.project.app.R;
import qtc.project.app.activity.CustomerActivity;
import qtc.project.app.api.fragment_customer.anticle.RequestListNews;
import qtc.project.app.api.fragment_customer.anticle.RequestListNewsCategory;
import qtc.project.app.dependency.AppProvider;
import qtc.project.app.dialog.option.OptionModel;
import qtc.project.app.event.BackShowRootViewEvent;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.NewsCategoryModel;
import qtc.project.app.model.customer.NewsModel;
import qtc.project.app.ui.views.fragment.fragment_customer.acticles.list_news.FragmentArticleCustomerView;
import qtc.project.app.ui.views.fragment.fragment_customer.acticles.list_news.FragmentArticleCustomerViewCallback;
import qtc.project.app.ui.views.fragment.fragment_customer.acticles.list_news.FragmentArticleCustomerViewInterface;

public class FragmentArticleCustomer extends BaseFragment<FragmentArticleCustomerViewInterface, BaseParameters> implements FragmentArticleCustomerViewCallback {

   CustomerActivity activity;
    String id_news;
    private int page = 1;
    private int totalPage = 0;
    @Override
    protected void initialize() {
        activity = (CustomerActivity)getActivity();
        view.init(activity, this);

        requestGetDataNews();
    }

    private void requestGetDataNews() {
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestListNewsCategory.ApiParams params = new RequestListNewsCategory.ApiParams();
        AppProvider.getApiManagement().call(RequestListNewsCategory.class, params, new ApiRequest.ApiCallback<BaseResponseModel<NewsCategoryModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<NewsCategoryModel> body) {
                dismissProgress();
                if (!TextUtils.isEmpty(body.getSuccess()) && body.getSuccess().equalsIgnoreCase("true")) {
                    view.setDataNews(body.getData());
                } else {
                    showAlert(body.getMessage(), KAlertDialog.ERROR_TYPE);
                }
            }

            @Override
            public void onError(ErrorApiResponse error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
            }

            @Override
            public void onFail(ApiRequest.RequestError error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
            }
        });
    }

    @Override
    public void refreshLoadingList() {
        page = 1;
        totalPage = 0;
        view.resetListData();
        onRequestNewDetail(id_news);
    }

    @Override
    public void onRequestLoadMoreList() {
        ++page;

        if (totalPage > 0 && page <= totalPage) {

            onRequestNewDetail(id_news);
        } else {
            view.setNoMoreLoading();
            showToast(getString(R.string.error_loadmore));
        }
    }

    @Override
    public void onRequestSearchWithFilter(String status, String key) {

    }

    @Override
    public void onItemListSelected(OptionModel item) {
        NewsModel model = (NewsModel) item.getDtaCustom();
        if (activity != null) {
            activity.changeToFragmentNewsDetail(model);
            activity.hideBottomMenuBar();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.hideRootView();
                }
            }, 700);
        }
    }

    @Override
    public void onClickAddItem() {

    }

    @Override
    public void onDeleteItemSelected(OptionModel item) {

    }

    @Override
    public void onClickFilter() {

    }

    @Override
    public void onRequestNewDetail(String id) {
        this.id_news = id;
        if (!AppProvider.getConnectivityHelper().hasInternetConnection()) {
            showAlert(getContext().getResources().getString(R.string.error_internet_connection), KAlertDialog.ERROR_TYPE);
            return;
        }
        showProgress();
        RequestListNews.ApiParams params = new RequestListNews.ApiParams();
        if (!TextUtils.isEmpty(id)) {
            params.id_category = id;
        }
        view.resetListData();
        AppProvider.getApiManagement().call(RequestListNews.class, params, new ApiRequest.ApiCallback<BaseResponseModel<NewsModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<NewsModel> result) {
                dismissProgress();
                if (!TextUtils.isEmpty(result.getSuccess()) && result.getSuccess().equalsIgnoreCase("true")) {

                    if (!TextUtils.isEmpty(result.getTotal_page())) {
                        totalPage = Integer.valueOf(result.getTotal_page());
                        if (page == totalPage) {
                            view.setNoMoreLoading();
                        }
                    } else {
                        view.setNoMoreLoading();
                    }
                    view.setDataList(result);
                } else {
                    if (!TextUtils.isEmpty(result.getMessage()))
                        showAlert(result.getMessage(), KAlertDialog.ERROR_TYPE);
                    else
                        showAlert("Không thể tải dữ liệu.", KAlertDialog.ERROR_TYPE);
                }
            }

            @Override
            public void onError(ErrorApiResponse error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
            }

            @Override
            public void onFail(ApiRequest.RequestError error) {
                dismissProgress();
                showAlert("Không tải được dữ liệu", KAlertDialog.ERROR_TYPE);
            }
        });
    }

    @Override
    protected FragmentArticleCustomerViewInterface getViewInstance() {
        return new FragmentArticleCustomerView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBackShowRootViewEvent(BackShowRootViewEvent event) {
        if (view != null) {
            view.showRootView();
        }
    }
}
