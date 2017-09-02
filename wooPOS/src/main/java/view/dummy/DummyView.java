package view.dummy;

import application.WooPOS;
import interfaces.PaymentMethod;
import interfaces.PosUI;
import java.awt.event.ActionListener;
import java.util.List;
import model.Product;
import model.ShoppingCart;

/**
 * A dummy view that does not display anything on the screen. For development/test
 * purposes.
 * 
 * @author kkirjala
 */
public class DummyView implements PosUI {

    @Override
    public void onPosStartup(WooPOS applicationContext) {
        
    }

    @Override
    public void onPosClose(WooPOS applicationContext) {
        
    }

    @Override
    public void generateProductButtons(List<Product> products, ActionListener listener) {
        
    }

    @Override
    public void generatePaymentButtons(List<PaymentMethod> paymentMethods, ActionListener listener) {
        
    }

    @Override
    public void setShoppingCartContentDisplay(ShoppingCart cart) {
        
    }
    
    
    
}
