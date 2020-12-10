package qtc.project.app.ui.views.fragment.account.register;


import qtc.project.app.model.UserRegisterModel;

public interface FragmentRegisterViewCallback {
    void onClickBackHeader();

    void onClickShowLoginForm();

    void onSignUp(UserRegisterModel userRegisterModel);

    void onRequestCheckPhoneRegister(UserRegisterModel userRegisterModel);

}
