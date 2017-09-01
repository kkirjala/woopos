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
import view.swing.ProductButton;

/**
 * Controller facilities for interacting with a shopping cart.
 *
 * @author kkirjala
 */
public class OrderController implements ActionListener, PosController, ShoppingCartListener {

    private PosUI ui;
    private WooPOS app;
    private ShoppingCart shoppingCart;



    public OrderController(WooPOS app) {

        this.app = app;
        this.ui = app.getUi();

        this.createShoppingCart();
        
    }

    /**
     * Initialize a new empty ShoppingCart. Controller will listen to the changes
     * and update the View accordingly.
     *
     */
    private void createShoppingCart() {
        this.shoppingCart = new ShoppingCart(); 
        
        this.shoppingCart.addShoppingCartListener(this);
    }

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

    
    private void generateUIProductButtons() {

        this.ui.generateProductButtons(app.getBackend().getProducts(), this);

    }

    /**
     * event listener for UI product button clicks.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {

        ProductButton prodButton = (ProductButton) e.getSource();
        Product prod = prodButton.getProduct();

        // TODO: lisää shoppingCartiin prod
        
        this.addProduct(this.shoppingCart, prod);               

    }

    @Override
    public void onPosStartup(WooPOS applicationContext) {
       
        this.generateUIProductButtons();
    }

    @Override
    public void onPosClose(WooPOS applicationContext) {
        
    }

    @Override
    public void onShoppingCartUpdated(ShoppingCart shoppingCart) {
        
        // this.ui can be null in test scope
        if (this.ui != null) {
            this.ui.setShoppingCartContentDisplay(this.getShoppingCart());
        }
        
    }

}
