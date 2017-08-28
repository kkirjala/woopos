/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.swing;

import interfaces.ShoppingCartListener;
import javax.swing.JPanel;

/**
 *
 * @author kkirjala
 */
public class ShoppingCartPanel extends JPanel implements ShoppingCartListener {

    public ShoppingCartPanel() {
        
        super();
        
    }
    
    // TODO:
    // shoppingcart -> getproducts -> piirrä näytölle
    private void DisplayShoppingCartContents() {
        
    }

    @Override
    public void onShoppingCartUpdated() {
        this.DisplayShoppingCartContents();
    }
    
}
