package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkirjala
 */
public class Order {
    
    private List<Product> products;
    private OrderStatus orderStatus;
    private int orderTotal;

    public Order(List<Product> products, int orderTotal) {
        this.products = products;
        this.orderStatus = OrderStatus.NEW;
        this.orderTotal = orderTotal;
    }

    public void changeOrderStatus(OrderStatus newStatus) {
        this.orderStatus = newStatus;
    }
    
    
}
