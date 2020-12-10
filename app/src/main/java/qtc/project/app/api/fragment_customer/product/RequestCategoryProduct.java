package qtc.project.app.api.fragment_customer.product;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.api.fragment_customer.dashboard.RequestListProductHome;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.CategoryProductModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("list_product_category")
public class RequestCategoryProduct  extends ApiRequest<RequestCategoryProduct.Service, BaseResponseModel<CategoryProductModel>, RequestCategoryProduct.ApiParams> {

    public RequestCategoryProduct() {
        super(RequestCategoryProduct.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<CategoryProductModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<CategoryProductModel>> call(RequestCategoryProduct.ApiParams params) {
        params.detect = "list_product_category";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<CategoryProductModel>> call(@Body RequestCategoryProduct.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
    }
}