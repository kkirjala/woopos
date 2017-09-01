package interfaces;

import application.WooPOS;
import model.Order;
import model.Payment;

/**
 *
 * @author kkirjala
 */
public interface PaymentMethod {

    /**
     * Method will be called during POS startup.
     */
    public void onPosStartup(WooPOS applicationContext);

    /**
     * Method will be called during POS close/shutdown.
     */
    public void onPosClose(WooPOS applicationContext);

    /**
     * Method will be called when creating a (partial) payment with the 
     * selected payment method
     *
     * @param order the order to be paid
     *
     * @return a Payment if successful, or null if not successful
     */
    public Payment createPayment(Order order);
    
    /**
     * Display name of the payment method (eg. Cash, Credit Card, Invoice)
     * @return Name of the payment method to be displayed in the UI
     */
    public String getDisplayName();
    

}
