package qtc.project.app.api.fragment_customer.dashboard;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.api.fragment_customer.contact.RequestContact;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ProductHomeModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("list_product_home")
public class RequestListProductHome  extends ApiRequest<RequestListProductHome.Service, BaseResponseModel<ProductHomeModel>, RequestListProductHome.ApiParams> {

    public RequestListProductHome() {
        super(RequestListProductHome.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<ProductHomeModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<ProductHomeModel>> call(RequestListProductHome.ApiParams params) {
        params.detect = "list_product_home";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<ProductHomeModel>> call(@Body RequestListProductHome.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
       public String id_category;
       public String id_product;
    }
}