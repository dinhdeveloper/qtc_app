package qtc.project.app.event;

import b.laixuantam.myaarlibrary.helper.BusHelper;

public class AlertCheckUserRolePermissionEvent {

    public static void post() {
        BusHelper.post(new AlertCheckUserRolePermissionEvent());
    }
}
