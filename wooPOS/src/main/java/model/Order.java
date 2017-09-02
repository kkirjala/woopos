package model;

import interfaces.OrderListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Model for Orders that are made from ShoppingCarts.
 * @author kkirjala
 */
public class Order {

    private List<Product> products;
    private OrderStatus orderStatus;
    private double orderTotal;
    private List<Payment> payments;
    private List<OrderListener> listeners;

    /**
     * Create a new order from a ShoppingCart contents.
     * @param products a List of Products.
     * @param orderTotal the grand total (including discounts)
     */
    public Order(List<Product> products, double orderTotal) {
        this.products = products;
        this.orderStatus = OrderStatus.NEW;
        this.orderTotal = orderTotal;
        this.payments = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    /**
     * Return Order's status.
     * @return orderStatus the status (OrderStatus enum)
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Modify Order's status.
     * @param orderStatus the status (OrderStatus enum)
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
                
        this.fireOnOrderUpdated();
    }

    /**
     * Add a full or partial Payment to the Order.
     * @param payment the Payment to add.
     */
    public void addPayment(Payment payment) {
        this.payments.add(payment);
        this.checkOrderPayments();
    }

    /**
     * Return the grand total of Order.
     * @return orderTotal grand total (double)
     */
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
    
    /**
     * Register an event listener to monitor Order's changes.
     * @param listener the OrderListener to register
     */
    public void addOrderListener(OrderListener listener) {
        this.listeners.add(listener);
    }
    
    /**
     * Fire an event every time the Order changes.
     */
    public void fireOnOrderUpdated() {
        for (OrderListener currListener : this.listeners) {
            currListener.onOrderUpdated(this);
        }
    }
    
}
