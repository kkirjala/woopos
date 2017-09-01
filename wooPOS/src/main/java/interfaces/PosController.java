package interfaces;

import application.WooPOS;

/**
 *
 * @author kkirjala
 */
public interface PosController {
    
        /**
     * Method will be called during POS startup.
     */
    public void onPosStartup(WooPOS applicationContext);

    /**
     * Method will be called during POS close/shutdown.
     */
    public void onPosClose(WooPOS applicationContext);
    
}
