/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.calculateCartTotal();
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
        this.calculateCartTotal();
    }

    public void addDiscountPercentage(int discountPercentage) {
        if (discountPercentage > 0) {
            this.discountsPercentage.add(discountPercentage);
        }
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

    public void addShoppingCartListener(ShoppingCartListener listener) {
        this.listeners.add(listener);
    }

    public void fireOnShoppingCartUpdated() {
        for (ShoppingCartListener currListener : this.listeners) {
            currListener.onShoppingCartUpdated();
        }
    }

}
