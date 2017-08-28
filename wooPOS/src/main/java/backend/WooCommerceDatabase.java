package backend;

import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import model.Order;
import model.Product;
import model.ShoppingCart;
import interfaces.PosBackend;
import java.util.List;

/**
 *
 * @author kkirjala
 */
public class WooCommerceDatabase implements PosBackend {

    @Override
    public void onPosStartup() {
        OAuthConfig config = new OAuthConfig("http://woocommerce.com", "consumerKey", "consumerSecret");
        WooCommerce wooCommerce = new WooCommerceAPI(config);
    }

    @Override
    public void onPosClose() {
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public Order createOrder(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public Order getOrder(Order order) {
        return null;
    }

}
