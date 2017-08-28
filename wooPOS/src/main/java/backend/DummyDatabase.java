package backend;
import interfaces.PosBackend;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Order;
import model.Product;
import model.ShoppingCart;

/**
 *
 * @author kalle
 */
public class DummyDatabase implements PosBackend {

    private ArrayList<Product> products;
    
    @Override
    public void onPosStartup() {
        
        this.products = new ArrayList<>();
        
        // generate 20 random Products
        for (int i = 1; i < 20; i++) {
            this.products.add(new Product("Product " + String.valueOf(i), new Random().nextDouble() * 100));
        }
        
    }

    @Override
    public void onPosClose() {
        this.products = null;
    }

    @Override
    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public void deleteProduct(Product product) {
        this.products.remove(product);
    }

    @Override
    public Order createOrder(ShoppingCart shoppingCart) {
        // TODO: unfinished
        return new Order(this.products, new Random().nextDouble() * 100);
    }

    @Override
    public Order getOrder(Order order) {
        // TODO: unfinished
        return new Order(this.products, new Random().nextDouble() * 100);
        
    }
    
    
    
}
