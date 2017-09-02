package interfaces;

import application.WooPOS;
import model.Order;
import model.Product;
import model.ShoppingCart;
import java.util.List;

/**
 * Interface class for WooPOS compatible database backends.
 * 
 * @author kkirjala
 */
public interface PosBackend {

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
     * Get a complete product list.
     *
     * @return a List containing all Product objects
     */
    public List<Product> getProducts();

    /**
     * Add a product to database.
     *
     * @param product the Product to be added
     */
    public void addProduct(Product product);

    /**
     * Delete a product from database.
     *
     * @param product the Product to be deleted
     */
    public void deleteProduct(Product product);

    /**
     * Turn a shopping cart into a new/pending order.
     *
     * @param shoppingCart the ShoppingCart object with Products
     *
     * @return Order object
     */
    public Order createOrder(ShoppingCart shoppingCart);

    /**
     * Fetch a specific order from the database.
     *
     * @param order the Order to be fetched
     *
     * @return Order object
     */
    public Order getOrder(Order order); // TODO: speksaa uusiksi?

}