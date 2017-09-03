package backend;

import application.WooPOS;
import interfaces.PosBackend;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Order;
import model.Product;
import model.ShoppingCart;

/**
 * A dummy Database for testing/development purposes. Randomized data.
 *
 * @author kalle
 */
public class DummyDatabase implements PosBackend {

    private List<Product> products;

    /**
     * Constructor will generate 20 randomized products.
     */
    public DummyDatabase() {
        this.products = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            this.addProduct(new Product("Product " + String.valueOf(i), new Random().nextDouble() * 100));
        }

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
        if (this.products != null) {
            return this.products;
        } else {
            return new ArrayList<Product>();
        }

    }

    /**
     * {@inheritDoc}
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteProduct(Product product) {
        this.products.remove(product);
    }

    /**
     * {@inheritDoc}
     */
    public Order createOrder(ShoppingCart shoppingCart) {
        return new Order(shoppingCart.getProducts(), shoppingCart.getTotalPrice());
    }

    /**
     * {@inheritDoc}
     */
    public Order getOrder(Order order) {
        // TODO: unfinished
        return new Order(this.products, new Random().nextDouble() * 100);

    }

}
