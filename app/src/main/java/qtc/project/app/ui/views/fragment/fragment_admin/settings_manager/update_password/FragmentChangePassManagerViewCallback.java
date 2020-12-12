package qtc.project.app.ui.views.fragment.fragment_admin.settings_manager.update_password;

public interface FragmentChangePassManagerViewCallback {
    void onBackHeader();

    void onRequestUpdatePassWord(String old_pass, String new_pass);
}
