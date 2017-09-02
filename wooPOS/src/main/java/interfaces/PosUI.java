package interfaces;

import application.WooPOS;
import java.awt.event.ActionListener;
import java.util.List;
import model.Product;
import model.ShoppingCart;
import view.swing.MainUI;

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

    public void generateProductButtons(List<Product> products, ActionListener listener);

    public void generatePaymentButtons(List<PaymentMethod> paymentMethods, ActionListener listener);

    public void setShoppingCartContentDisplay(ShoppingCart cart);

}
