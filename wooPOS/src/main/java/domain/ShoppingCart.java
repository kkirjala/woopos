/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.sun.media.jfxmedia.logging.Logger;
import interfaces.ShoppingCartListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkirjala
 */
public class ShoppingCart {

    
    private List<Product> products;
    private double totalPrice;
    private List<Integer> discountsPercentage;
    private List<Integer> discountsFixedAmount;
    private List<ShoppingCartListener> listeners;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.discountsFixedAmount = new ArrayList<>();
        this.discountsPercentage = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.calculateCartTotal();
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
        this.calculateCartTotal();
    }

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

    /* 
        A method for adding a discount-% to the list of discounts
        applied to the shopping cart 
     */
    public void applyDiscountPercentage(int discountPercentage) {
        this.discountsPercentage.add(discountPercentage);
        this.calculateCartTotal();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addShoppingCartListener(ShoppingCartListener listener) {
        this.listeners.add(listener);
    }

    public void fireOnShoppingCartUpdated() {
        for (ShoppingCartListener currListener : this.listeners) {
            currListener.onShoppingCartUpdated();
        }
    }

}
