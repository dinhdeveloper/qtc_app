package qtc.project.app.api.fragment_customer.product;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.ProductDetailModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("list_product_detail")
public class RequestProductDetail  extends ApiRequest<RequestProductDetail.Service, BaseResponseModel<ProductDetailModel>, RequestProductDetail.ApiParams> {

    public RequestProductDetail() {
        super(RequestProductDetail.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<ProductDetailModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<ProductDetailModel>> call(RequestProductDetail.ApiParams params) {
        params.detect = "list_product_detail";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<ProductDetailModel>> call(@Body RequestProductDetail.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
        public String product_id;
    }
}