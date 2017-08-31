package interfaces;

import application.WooPOS;
import model.Order;

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
     * Method will be called when creating a payment with the selected payment method
     *
     * @param order the order to be paid
     *
     * @return whether the payment was successful or not (boolean)
     */
    public boolean createPayment(Order order);

}
