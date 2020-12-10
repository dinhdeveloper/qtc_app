package qtc.project.app.api.fragment_customer.anticle;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.api.fragment_customer.contact.RequestContact;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.NewsModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("list_news_news")
public class RequestListNews extends ApiRequest<RequestListNews.Service, BaseResponseModel<NewsModel>, RequestListNews.ApiParams> {

    public RequestListNews() {
        super(RequestListNews.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<NewsModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<NewsModel>> call(RequestListNews.ApiParams params) {
        params.detect = "list_news_news";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<NewsModel>> call(@Body RequestListNews.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
        public String id_category;
    }
}
