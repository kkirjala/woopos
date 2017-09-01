/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.WooPOS;
import backend.DummyDatabase;
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
public class ShoppingCartController implements ActionListener, PosController, ShoppingCartListener {

    private PosUI ui;
    private WooPOS app;
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public ShoppingCartController(WooPOS app) {

        this.app = app;
        this.ui = app.getUi();

        this.createShoppingCart();
        
    }

    /**
     * Initialize a new empty ShoppingCart
     *
     */
    public void createShoppingCart() {
        this.shoppingCart = new ShoppingCart(); 
        
        this.shoppingCart.addShoppingCartListener(this);
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
        
        // TODO: remove this one, Dummy used for dev purposes
        DummyDatabase db = new DummyDatabase();

        this.ui.generateProductButtons(db.getProducts(), this);

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
        // TODO:
        // metodi, joka syöttää tuotteet view:lle ja rekisteröi controllerin
        // eventtikuuntelijaksi näppäinpainalluksille.
        
        this.generateUIProductButtons();
    }

    @Override
    public void onPosClose(WooPOS applicationContext) {
        
    }

    @Override
    public void onShoppingCartUpdated(ShoppingCart shoppingCart) {
        
        if (this.ui != null) {
            this.ui.setShoppingCartContentDisplay(this.getShoppingCart());
        }
        
    }

}
