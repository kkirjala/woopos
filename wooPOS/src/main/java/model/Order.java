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
    private double orderTotal;

    public Order(List<Product> products, double orderTotal) {
        this.products = products;
        this.orderStatus = OrderStatus.NEW;
        this.orderTotal = orderTotal;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    
}
