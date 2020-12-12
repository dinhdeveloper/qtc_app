package qtc.project.app.api.fargment_admin;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.api.fragment_customer.slider.RequestGetSlideHeaderReview;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ImageSlideModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("setting")
public class RequestUpdateProfile  extends ApiRequest<RequestUpdateProfile.Service, BaseResponseModel<ImageSlideModel>, RequestUpdateProfile.ApiParams> {

    public RequestUpdateProfile() {
        super(RequestUpdateProfile.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<ImageSlideModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<ImageSlideModel>> call(RequestUpdateProfile.ApiParams params) {
        params.detect = "setting";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<ImageSlideModel>> call(@Body RequestUpdateProfile.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
        public String type_manager;
        public String id_login;
        public String old_pass;
        public String new_pass;
    }
}