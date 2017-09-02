package interfaces;

import application.WooPOS;

/**
 * Interface specification for WooPOS controller classes.
 *
 * @author kkirjala
 */
public interface PosController {

    /**
     * Method will be called during POS startup.
     * @param applicationContext WooPOS application instance
     */
    public void onPosStartup(WooPOS applicationContext);

    /**
     * Method will be called during POS close/shutdown.
     * @param applicationContext WooPOS application instance
     */
    public void onPosClose(WooPOS applicationContext);

}
