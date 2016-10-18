package cclient;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

public class CClientApp extends SingleFrameApplication {
    @Override protected void startup() {
        show(new Login(this));

    }
    @Override protected void configureWindow(java.awt.Window root) {
    }

    public static CClientApp getApplication() {
        return Application.getInstance(CClientApp.class);
    }

    public static void main(String[] args) {
        launch(CClientApp.class, args);
    }
}
