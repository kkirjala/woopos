/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Product;
import domain.ShoppingCart;
import interfaces.ShoppingCartListener;

/**
 *
 * @author kkirjala
 */
public class ShoppingCartController {

    public ShoppingCartController() {
    }
    
    
    public ShoppingCart createShoppingCart() {
        return new ShoppingCart();
    }
    
        
    public void addProduct(ShoppingCart cart, Product product) {
        cart.addProduct(product);
    }

    public void removeProduct(ShoppingCart cart, Product product) {
        cart.removeProduct(product);
    }

    /* 
        A method for adding a discount-% to the list of discounts
        applied to the shopping cart 
     */
    public void applyDiscountPercentage(ShoppingCart cart, int discountPercentage) {
        cart.addDiscountPercentage(discountPercentage);
    }



    
}
