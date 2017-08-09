
import java.util.ArrayList;

/**
 *
 * @author kkirjala
 */
public class Order {
    
    private ArrayList products;

    public Order() {
    }
    
    public void addProduct (Product product) {
        this.products.add(product);
    }
    
    public int calculateOrderTotal() {
        
        int price = 0;
        
        while (this.products.iterator().hasNext()) {
            price += this.products.iterator().next().getPrice();
        }
        
        return price;
    }
    
    
}
