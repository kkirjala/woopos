package interfaces;

import model.Order;

/**
 * Interface class for making listeners that monitor changes in Order objects.
 * @author kkirjala
 */
public interface OrderListener {

    /**
     * Method that is called everytime the order changes.
     *
     * @param order the order that has changed.
     */
    public void onOrderUpdated(Order order);

}
