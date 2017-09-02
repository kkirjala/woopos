package interfaces;

import model.Order;

/**
 *
 * @author kkirjala
 */
public interface OrderListener {

    /**
     * Method that is called everytime the order changes.
     *
     * @param order
     */
    public void onOrderUpdated(Order order);

}
