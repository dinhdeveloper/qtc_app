package qtc.project.app.api.fragment_customer.anticle;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.api.fragment_customer.product.RequestProductDetail;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.NewsDetailModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("list_news_detail")
public class RequestNewsDetail extends ApiRequest<RequestNewsDetail.Service, BaseResponseModel<NewsDetailModel>, RequestNewsDetail.ApiParams> {

    public RequestNewsDetail() {
        super(RequestNewsDetail.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<NewsDetailModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<NewsDetailModel>> call(RequestNewsDetail.ApiParams params) {
        params.detect = "list_news_detail";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<NewsDetailModel>> call(@Body RequestNewsDetail.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
        public String product_id;
    }
}