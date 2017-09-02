package interfaces;

import application.WooPOS;
import java.awt.event.ActionListener;
import java.util.List;
import model.Product;
import model.ShoppingCart;
import view.swing.MainUI;

/**
 * Interface specification for WooPOS user interfaces.
 * @author kalle
 */
public interface PosUI {

    /**
     * Method that is called during POS startup.
     * @param applicationContext WooPOS application instance
     */
    public void onPosStartup(WooPOS applicationContext);

    /**
     * Method that is called during POS close/shutdown.
     * @param applicationContext WooPOS application instance
     */
    public void onPosClose(WooPOS applicationContext);

    /**
     * Generate the UI widgets for adding products to the shopping cart.
     * @param products a list of Products.
     * @param listener an event Listener for add to cart button clicks.
     */
    public void generateProductButtons(List<Product> products, ActionListener listener);

    /**
     * Generate the UI widgets for taking payments.
     * @param paymentMethods a list of PaymentMethods.
     * @param listener an event Listener for create payment button clicks.
     */
    public void generatePaymentButtons(List<PaymentMethod> paymentMethods, ActionListener listener);

    /**
     * Method for changing the contents of the UI widget that displays the
     * current contents of the shopping cart.
     * 
     * @param cart a ShoppingCart with contents to be displayed.
     */
    public void setShoppingCartContentDisplay(ShoppingCart cart);

}
