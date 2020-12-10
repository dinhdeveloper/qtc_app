package qtc.project.app.ui.views.fragment.account.login;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;

public interface LoginViewInterface extends BaseViewInterface {
    void initialize(LoginViewCallback callback);

    void showRootViewLogin();

    void hideRootViewLogin();

//    void setUpFacebookLoginButton(Fragment fragment, CallbackManager callbackManager);
}
