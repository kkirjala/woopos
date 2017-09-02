package backend;

import application.WooPOS;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import model.Order;
import model.Product;
import model.ShoppingCart;
import interfaces.PosBackend;
import java.util.List;

/**
 * This class uses WooCommerce WordPress plugin as the backend of WooPOS.
 *
 * @author kkirjala
 */
public class WooCommerceDatabase implements PosBackend {

    /**
     * Opening a HTTP socket for to access the REST API of a WooCommerce
     * installation.
     */
    public WooCommerceDatabase() {
        OAuthConfig config = new OAuthConfig("http://woocommerce.com", "consumerKey", "consumerSecret");
        WooCommerce wooCommerce = new WooCommerceAPI(config);
    }

    /**
     * {@inheritDoc}
     */
    public void onPosStartup(WooPOS applicationContext) {
    }

    /**
     * {@inheritDoc}
     */
    public void onPosClose(WooPOS applicationContext) {
    }

    /**
     * {@inheritDoc}
     */
    public List<Product> getProducts() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void addProduct(Product product) {

    }

    /**
     * {@inheritDoc}
     */
    public void deleteProduct(Product product) {

    }

    /**
     * {@inheritDoc}
     */
    public Order createOrder(ShoppingCart shoppingCart) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Order getOrder(Order order) {
        return null;
    }

}
