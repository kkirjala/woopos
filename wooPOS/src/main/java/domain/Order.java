package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkirjala
 */
public class Order {
    
    private List<Product> products;

    public Order() {
        this.products = new ArrayList();
    }
    
    public void addProduct (Product product) {
        this.products.add(product);
    }
    
    public int calculateOrderTotal() {
        
        int price = 0;

        for (Product currProduct : this.products) {
            price += currProduct.getPrice();
        }
                
        return price;
    }
    
    
}
