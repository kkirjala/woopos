/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.ShoppingCart;

/**
 *
 * @author kkirjala
 */
public interface ShoppingCartListener {

    /**
     * Method that is called everytime the ShoppingCart's contents change.
     */
    public void onShoppingCartUpdated(ShoppingCart shoppingCart);

}
