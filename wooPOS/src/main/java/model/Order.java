package model;

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
    private List<Payment> payments;

    public Order(List<Product> products, double orderTotal) {
        this.products = products;
        this.orderStatus = OrderStatus.NEW;
        this.orderTotal = orderTotal;
        this.payments = new ArrayList<>();
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }
    
}
