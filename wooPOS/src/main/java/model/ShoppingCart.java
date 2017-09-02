package model;

import interfaces.ShoppingCartListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A ShoppingCart will contain the products to be purchased.
 * @author kkirjala
 */
public class ShoppingCart {

    private List<Product> products;
    private double totalPrice;
    private List<Integer> discountsPercentage;
    private List<Integer> discountsFixedAmount;
    private List<ShoppingCartListener> listeners;

    /**
     * Initialize a new ShoppingCart.
     */
    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.discountsFixedAmount = new ArrayList<>();
        this.discountsPercentage = new ArrayList<>();
    }

    /**
     * Get grand total (including discounts).
     * @return grand total (a double).
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Get a List of Products currently in the cart.
     * @return List of products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Add a Product to the cart.
     * @param product to be added.
     */
    public void addProduct(Product product) {
        this.products.add(product);
        this.calculateCartTotal();
    }

    /**
     * Remove a Product from the Cart.
     * @param product to be removed.
     */
    public void removeProduct(Product product) {
        this.products.remove(product);
        this.calculateCartTotal();
    }

    /**
     * Add a discount to the list of discounts to be applied to this specific
     * ShoppingCart.
     * @param discountPercentage an integer value of percentage discount (0-100)
     */
    public void addDiscountPercentage(int discountPercentage) {
        if (discountPercentage > 0) {
            this.discountsPercentage.add(discountPercentage);
        }
        this.calculateCartTotal();
    }

    /**
     * Calculate cart's total price.
     */
    private void calculateCartTotal() {

        this.totalPrice = 0;

        //  product prices
        for (Product currProduct : this.products) {
            this.totalPrice += currProduct.getPrice();
        }

        // discounts (%)
        for (int currDiscount : this.discountsPercentage) {
            if (currDiscount > 0) {
                this.totalPrice *= currDiscount;
                this.totalPrice /= 100;
            }
        }

        // discounts (fixed amounts)
        for (int currDiscount : this.discountsFixedAmount) {
            this.totalPrice -= currDiscount;
        }

        this.fireOnShoppingCartUpdated();

    }

    /**
     * Register a new listener to monitor changes in this cart.
     * @param listener a ShoppingCartListener
     */
    public void addShoppingCartListener(ShoppingCartListener listener) {
        this.listeners.add(listener);
        this.fireOnShoppingCartUpdated();
    }

    /**
     * Fire an event every time the ShoppingCart changes.
     */
    public void fireOnShoppingCartUpdated() {
        for (ShoppingCartListener currListener : this.listeners) {
            currListener.onShoppingCartUpdated(this);
        }
    }

}
