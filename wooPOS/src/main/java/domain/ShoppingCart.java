/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.ShoppingCartListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkirjala
 */
public class ShoppingCart {

    private List<Product> products;
    private int totalPrice;
    private List<ShoppingCartListener> listeners;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        this.products.add(product);
        this.calculateCartTotal();
    }
    
    public void removeProduct(Product product) {
        this.products.remove(product);
        this.calculateCartTotal();
    }
    
    public void calculateCartTotal() {

        this.totalPrice = 0;

        for (Product currProduct : this.products) {
            this.totalPrice += currProduct.getPrice();
        }
        
        this.fireOnShoppingCartUpdated();

    }
    
    public void applyDiscountPercentage(int discountPercentage) {
        this.totalPrice = this.totalPrice * (discountPercentage / 100);
        this.calculateCartTotal();
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
