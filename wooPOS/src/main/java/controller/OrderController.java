/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.WooPOS;
import interfaces.PosController;
import interfaces.PosUI;
import interfaces.ShoppingCartListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Product;
import model.ShoppingCart;
import view.swing.buttons.ProductButton;

/**
 * Controller facilities for interacting with a shopping cart.
 *
 * @author kkirjala
 */
public class OrderController implements PosController, ShoppingCartListener, ActionListener {

    private PosUI ui;
    private WooPOS app;
    private ShoppingCart shoppingCart;

    public OrderController(WooPOS app) {

        this.app = app;
        this.ui = app.getUi();

        this.createShoppingCart();

    }

    /**
     * Initialize a new empty ShoppingCart. Controller will listen to the
     * changes and update the View accordingly.
     *
     */
    private void createShoppingCart() {
        this.shoppingCart = new ShoppingCart();

        this.shoppingCart.addShoppingCartListener(this);
    }

    /**
     * Get a reference to the currently active shopping cart
     *
     * @return shoppingCart
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Add a Product to a ShoppingCart
     *
     * @param cart the ShoppingCart that will be updated
     * @param product the Product to add
     *
     */
    public void addProduct(ShoppingCart cart, Product product) {
        cart.addProduct(product);
    }

    /**
     * Remove a Product from a ShoppingCart
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
     * @param discountPercentage integer value specifying the discount, 0-100.
     */
    public void applyDiscountPercentage(ShoppingCart cart, int discountPercentage) {
        cart.addDiscountPercentage(discountPercentage);
    }


    /**
     * event listener for UI product button clicks.
     *
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        
        switch (event.getActionCommand()) {
            case "add_product_to_cart":

                ProductButton prodButton = (ProductButton) event.getSource();
                Product prod = prodButton.getProduct();

                this.addProduct(this.shoppingCart, prod);

                break;
            case "create_payment":
                // TODO: check the amount to be debited and pass it on to the
                // appropriate payment method as indicated by the button pressed
                
                break;
            default:
                break;

        }
    }

    @Override
    public void onPosStartup(WooPOS applicationContext) {

        this.ui.generateProductButtons(app.getBackend().getProducts(), this);
        
    }

    @Override
    public void onPosClose(WooPOS applicationContext) {

    }

    /**
     * Event listener is triggered when shopping cart's contents get updated.
     * @param shoppingCart 
     */
    @Override
    public void onShoppingCartUpdated(ShoppingCart shoppingCart) {

        // this.ui can be null in test scope
        if (this.ui != null) {
            this.ui.setShoppingCartContentDisplay(this.getShoppingCart());
        }

    }

}
