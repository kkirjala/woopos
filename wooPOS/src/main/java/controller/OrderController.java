package controller;

import application.WooPOS;
import interfaces.OrderListener;
import interfaces.PaymentMethod;
import interfaces.PosController;
import interfaces.PosUI;
import interfaces.ShoppingCartListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Order;
import model.Payment;
import model.Product;
import model.ShoppingCart;
import view.swing.buttons.PaymentButton;
import view.swing.buttons.ProductButton;

/**
 * Main Controller.
 *
 * @author kkirjala
 */
public class OrderController implements PosController, ShoppingCartListener, OrderListener, ActionListener {

    private PosUI ui;
    private WooPOS app;
    private ShoppingCart shoppingCart;

    /**
     * Inits a new OrderController for manipulating shopping cart, products etc.
     *
     * @param app a WooPOS application instance.
     */
    public OrderController(WooPOS app) {

        this.app = app;
        this.ui = app.getUi();

    }

    /**
     * Initialize a new empty ShoppingCart.
     */
    private void createShoppingCart() {
        this.shoppingCart = new ShoppingCart();

        this.shoppingCart.addShoppingCartListener(this);
    }

    /**
     * Get a reference to the currently active shopping cart.
     *
     * @return shoppingCart
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Add a Product to a ShoppingCart.
     *
     * @param cart the ShoppingCart that will be updated
     * @param product the Product to add
     *
     */
    public void addProduct(ShoppingCart cart, Product product) {
        cart.addProduct(product);
    }

    /**
     * Remove a Product from a ShoppingCart.
     *
     * @param cart the ShoppingCart to be updated
     * @param product the Product to be removed
     *
     */
    public void removeProduct(ShoppingCart cart, Product product) {
        cart.removeProduct(product);
    }

    /**
     * Apply a percentage discount to the ShoppingCart Deducts a specified
     * percent from the total value of the cart.
     *
     * @param cart shopping cart
     * @param discountPercentage integer value specifying the discount, 0-100.
     */
    public void applyDiscountPercentage(ShoppingCart cart, int discountPercentage) {
        cart.addDiscountPercentage(discountPercentage);
    }

    /**
     * Creates a new Order from shoppingcart contents.
     *
     * @param cart the cart to be turned into an order
     * @return order
     */
    public Order createOrder(ShoppingCart cart) {

        Order newOrder = new Order(cart.getProducts(), cart.getTotalPrice());
        newOrder.addOrderListener(this);

        // TODO: testaa tyhjällä korilla
        return newOrder;

    }

    /**
     * Create a payment for an Order using a specified PaymentMethod.
     *
     * @param order Order to be paid
     * @param paymentMethod PaymentMethod to use for payment.
     */
    public void createPayment(Order order, PaymentMethod paymentMethod) {
        // TODO: testaa nollasummalla
        Payment payment = paymentMethod.createPayment(order);

        if (payment != null) {
            order.addPayment(payment);
        }

    }

    /**
     * Event listener for UI button clicks.
     *
     * @param event triggered by UI component
     */
    public void actionPerformed(ActionEvent event) {

        switch (event.getActionCommand()) {
            case "add_product_to_cart":

                ProductButton prodButton = (ProductButton) event.getSource();
                Product prod = prodButton.getProduct();

                this.addProduct(this.shoppingCart, prod);

                break;
            case "create_payment":
                PaymentButton pmtButton = (PaymentButton) event.getSource();
                PaymentMethod pmtMethod = pmtButton.getPaymentMethod();

                this.createPayment(this.createOrder(this.shoppingCart), pmtMethod);

                break;
            default:
                break;

        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPosStartup(WooPOS applicationContext) {

        this.ui.generateProductButtons(app.getBackend().getProducts(), this);
        this.ui.generatePaymentButtons(app.getPaymentMethods(), this);

        this.createShoppingCart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPosClose(WooPOS applicationContext) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onShoppingCartUpdated(ShoppingCart shoppingCart) {

        this.ui.setShoppingCartContentDisplay(shoppingCart);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onOrderUpdated(Order order) {

        switch (order.getOrderStatus()) {
            case PAID: // order finished, new cart
                this.createShoppingCart();
                break;
            default:
                break;
        }

    }

}
