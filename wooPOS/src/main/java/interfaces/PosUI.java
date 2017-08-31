package interfaces;

import application.WooPOS;
import java.util.List;

/**
 *
 * @author kalle
 */
public interface PosUI {

    /**
     * Method that is called during POS startup.
     */
    public void onPosStartup(WooPOS applicationContext);

    /**
     * Method that is called during POS close/shutdown.
     */
    public void onPosClose(WooPOS applicationContext);
    
}
