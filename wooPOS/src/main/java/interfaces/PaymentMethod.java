package interfaces;

import model.Order;

/**
 *
 * @author kkirjala
 */
public interface PaymentMethod {

    /*
    - kassan auetessa (event)
- kassan sulkeutuessa (event)
- maksun kuittaus (true/false)
     */
    public void onPosStartup();

    public void onPosClose();
    
    public boolean createPayment(Order order);
    
}
