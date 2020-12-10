package qtc.project.app.event;

import b.laixuantam.myaarlibrary.helper.BusHelper;

public class BackShowRootViewEvent {

    public static void post() {
        BusHelper.post(new BackShowRootViewEvent());
    }
}
