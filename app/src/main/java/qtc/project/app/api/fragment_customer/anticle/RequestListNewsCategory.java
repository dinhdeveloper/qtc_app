package qtc.project.app.api.fragment_customer.anticle;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.NewsCategoryModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("list_news_category")
public class RequestListNewsCategory extends ApiRequest<RequestListNewsCategory.Service, BaseResponseModel<NewsCategoryModel>, RequestListNewsCategory.ApiParams> {

    public RequestListNewsCategory() {
        super(RequestListNewsCategory.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<NewsCategoryModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<NewsCategoryModel>> call(RequestListNewsCategory.ApiParams params) {
        params.detect = "list_news_category";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<NewsCategoryModel>> call(@Body RequestListNewsCategory.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
    }
}
