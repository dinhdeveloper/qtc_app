package qtc.project.app.event;

import b.laixuantam.myaarlibrary.helper.BusHelper;

public class UpdateDataEvent {

    public static void post() {
        BusHelper.post(new UpdateDataEvent());
    }
}
