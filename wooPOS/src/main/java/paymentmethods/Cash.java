package paymentmethods;

import application.WooPOS;
import interfaces.PaymentMethod;
import model.Order;
import model.Payment;

/**
 *
 * @author kkirjala
 */
public class Cash implements PaymentMethod {

    @Override
    public void onPosStartup(WooPOS applicationContext) {        
    }

    @Override
    public void onPosClose(WooPOS applicationContext) {
    }

    @Override
    public Payment createPayment(Order order) {
        return new Payment(order.getOrderTotal(), this.getDisplayName());
    }

    @Override
    public String getDisplayName() {
        return "Cash";
    }
    
    
    
}
