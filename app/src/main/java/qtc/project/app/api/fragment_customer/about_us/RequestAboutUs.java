package qtc.project.app.api.fragment_customer.about_us;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.api.fragment_customer.contact.RequestContact;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.AboutUsModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("about_us")
public class RequestAboutUs  extends ApiRequest<RequestAboutUs.Service, BaseResponseModel<AboutUsModel>, RequestAboutUs.ApiParams> {

    public RequestAboutUs() {
        super(RequestAboutUs.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<AboutUsModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<AboutUsModel>> call(RequestAboutUs.ApiParams params) {
        params.detect = "about_us";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<AboutUsModel>> call(@Body RequestAboutUs.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
    }
}