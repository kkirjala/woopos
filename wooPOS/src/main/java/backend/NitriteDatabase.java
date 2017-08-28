package backend;

import model.Order;
import model.Product;
import model.ShoppingCart;
import interfaces.PosBackend;
import java.util.List;
import org.dizitart.no2.Nitrite;

/**
 * A simple local NoSQL database for storing the information needed by WooPOS.
 * @author kkirjala
 */
public class NitriteDatabase implements PosBackend {

    private Nitrite db;

    public void onPosStartup() {
        this.db = Nitrite.builder()
                .compressed()
                .filePath("woopos.db")
                .openOrCreate("user", "password");
    }

    public void onPosClose() {
        this.db.close();
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
