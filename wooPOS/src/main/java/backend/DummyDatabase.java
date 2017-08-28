package backend;
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

    private ArrayList<Product> products;
    
    public void onPosStartup() {
        
        this.products = new ArrayList<>();
        
        // generate 20 random Products
        for (int i = 0; i < 20; i++) {
            this.addProduct(new Product("Product " + String.valueOf(i), new Random().nextDouble() * 100));
        }
        
    }

    public void onPosClose() {
        this.products = null;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(Product product) {
        this.products.remove(product);
    }

    public Order createOrder(ShoppingCart shoppingCart) {
        // TODO: unfinished
        return new Order(this.products, new Random().nextDouble() * 100);
    }

    public Order getOrder(Order order) {
        // TODO: unfinished
        return new Order(this.products, new Random().nextDouble() * 100);
        
    }
    
    
    
}
