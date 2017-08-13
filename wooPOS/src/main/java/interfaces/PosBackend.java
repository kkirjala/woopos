package interfaces;

import domain.Order;
import domain.Product;
import domain.ShoppingCart;
import java.util.List;

/**
 *
 * @author kkirjala
 */
public interface PosBackend {
        
        public void onPosStartup();
    
        public void onPosClose();
        
        public List<Product> getProducts();
        
        public void addProduct(Product product);
        
        public void deleteProduct(Product product);
        
        public Order createOrder(ShoppingCart shoppingCart);
        
        public Order getOrder(Order order); // TODO: speksaa uusiksi?
        
}
