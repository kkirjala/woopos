package backend;

import application.WooPOS;
import model.Order;
import model.Product;
import model.ShoppingCart;
import interfaces.PosBackend;
import java.util.List;
import org.dizitart.no2.Nitrite;

/**
 * A simple local NoSQL database for storing the information needed by WooPOS.
 *
 * @author kkirjala
 */
public class NitriteDatabase implements PosBackend {

    private Nitrite db;

    /**
     * A local file woopos.db will contain the Nitrite NoSQL database
     * information (metadata and data) needed by the application.
     */
    public NitriteDatabase() {
        this.db = Nitrite.builder()
                .compressed()
                .filePath("woopos.db")
                .openOrCreate("user", "password");
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
        this.db.close();
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
