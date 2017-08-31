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
 * @author kkirjala
 */
public class WooCommerceDatabase implements PosBackend {

    public void onPosStartup(WooPOS applicationContext) {
        OAuthConfig config = new OAuthConfig("http://woocommerce.com", "consumerKey", "consumerSecret");
        WooCommerce wooCommerce = new WooCommerceAPI(config);
    }

    public void onPosClose(WooPOS applicationContext) {
    }

    public List<Product> getProducts() {
        return null;
    }

    public void addProduct(Product product) {

    }

    public void deleteProduct(Product product) {

    }

    public Order createOrder(ShoppingCart shoppingCart) {
        return null;
    }

    public Order getOrder(Order order) {
        return null;
    }

}
