package qtc.project.app.ui.views.fragment.account.forgot_password;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import qtc.project.app.activity.HomeActivity;

public interface FragmentForgotPasswordViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentForgotPasswordViewCallback callback);

    void checkPhoneRegisterSuccessExists();

    void setCodeSMS(String code);

    void verifySMSSuccess();

    void verifySMSFailed();
}
