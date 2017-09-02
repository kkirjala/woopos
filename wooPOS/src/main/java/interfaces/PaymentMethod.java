package interfaces;

import application.WooPOS;
import model.Order;
import model.Payment;

/**
 * Payment Method for making and registering payments of Orders.
 * @author kkirjala
 */
public interface PaymentMethod {

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

    /**
     * Method will be called when creating a (partial) payment with the 
     * selected payment method.
     *
     * @param order the order to be paid
     *
     * @return a Payment if successful, or null if not successful
     */
    public Payment createPayment(Order order);
    
    /**
     * Display name of the payment method (eg. Cash, Credit Card, Invoice).
     * 
     * @return Name of the payment method to be displayed in the UI
     */
    public String getDisplayName();
    

}
