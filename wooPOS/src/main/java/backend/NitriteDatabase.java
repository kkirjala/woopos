package backend;

import model.Order;
import model.Product;
import model.ShoppingCart;
import interfaces.PosBackend;
import java.util.List;
import org.dizitart.no2.Nitrite;

/**
 *
 * @author kkirjala
 */
public class NitriteDatabase implements PosBackend {

    private Nitrite db;

    @Override
    public void onPosStartup() {
        this.db = Nitrite.builder()
                .compressed()
                .filePath("woopos.db")
                .openOrCreate("user", "password");
    }

    @Override
    public void onPosClose() {
        this.db.close();
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
