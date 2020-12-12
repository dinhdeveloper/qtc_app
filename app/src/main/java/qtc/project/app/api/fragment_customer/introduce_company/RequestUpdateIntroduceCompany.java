package qtc.project.app.api.fragment_customer.introduce_company;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import qtc.project.app.helper.Consts;
import qtc.project.app.model.BaseResponseModel;
import qtc.project.app.model.customer.CompanyModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("introduce_company")
public class RequestUpdateIntroduceCompany extends ApiRequest<RequestUpdateIntroduceCompany.Service, BaseResponseModel<CompanyModel>, RequestUpdateIntroduceCompany.ApiParams> {

    public RequestUpdateIntroduceCompany() {
        super(RequestUpdateIntroduceCompany.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<CompanyModel> result) {

    }

    @Override
    protected Call<BaseResponseModel<CompanyModel>> call(RequestUpdateIntroduceCompany.ApiParams params) {
        params.detect = "introduce_company";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<CompanyModel>> call(@Body RequestUpdateIntroduceCompany.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        String detect;
        public String type_manager;
        public String id_aboutus;
        public String about_title;
        public String about_content;
    }
}
