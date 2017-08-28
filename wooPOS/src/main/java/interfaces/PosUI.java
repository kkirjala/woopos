package interfaces;

/**
 *
 * @author kalle
 */
public interface PosUI {

    /**
     * Method that is called during POS startup.
     */
    public void onPosStartup();

    /**
     * Method that is called during POS close/shutdown.
     */
    public void onPosClose();

}
