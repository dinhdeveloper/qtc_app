package qtc.project.app.api.fragment_customer.contact;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.api.fragment_customer.slider.RequestGetSlideHeaderReview;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ContactModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("contact")
public class RequestContact  extends ApiRequest<RequestContact.Service, BaseResponseModel<ContactModel>, RequestContact.ApiParams> {

    public RequestContact() {
        super(RequestContact.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<ContactModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<ContactModel>> call(RequestContact.ApiParams params) {
        params.detect = "contact";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<ContactModel>> call(@Body RequestContact.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
    }
}