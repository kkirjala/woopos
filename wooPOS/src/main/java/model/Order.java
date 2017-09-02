package model;

import interfaces.OrderListener;
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
    private List<OrderListener> listeners;

    public Order(List<Product> products, double orderTotal) {
        this.products = products;
        this.orderStatus = OrderStatus.NEW;
        this.orderTotal = orderTotal;
        this.payments = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
                
        this.fireOnOrderUpdated();
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
        this.checkOrderPayments();
    }

    public double getOrderTotal() {
        return orderTotal;
    }
    
    /**
     * A utility method for automatically checking whether order is unpaid,
     * partially paid or fully paid and updates the order's status accordingly.
     */
    private void checkOrderPayments() {
        
        double paidAmount = 0.00;
        
        for (Payment currPayment : this.payments) {
            paidAmount += currPayment.getAmount();
        }
        
        if (paidAmount >= this.getOrderTotal()) {
            this.setOrderStatus(OrderStatus.PAID);
        } else {
            this.setOrderStatus(OrderStatus.AWAITING_PAYMENT);
        }
        
    }
    
    public void addOrderListener(OrderListener listener) {
        this.listeners.add(listener);
    }
    
    public void fireOnOrderUpdated() {
        for (OrderListener currListener : this.listeners) {
            currListener.onOrderUpdated(this);
        }
    }
    
}
