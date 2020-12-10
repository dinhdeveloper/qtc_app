package qtc.project.app.api.fragment_customer.slider;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ImageSlideModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("home_slide")
public class RequestGetSlideHeaderReview extends ApiRequest<RequestGetSlideHeaderReview.Service, BaseResponseModel<ImageSlideModel>, RequestGetSlideHeaderReview.ApiParams> {

    public RequestGetSlideHeaderReview() {
        super(RequestGetSlideHeaderReview.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<ImageSlideModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<ImageSlideModel>> call(RequestGetSlideHeaderReview.ApiParams params) {
        params.detect = "home_slide";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<ImageSlideModel>> call(@Body RequestGetSlideHeaderReview.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
    }
}