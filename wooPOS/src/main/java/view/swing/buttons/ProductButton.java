/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.swing.buttons;

import javax.swing.JButton;
import model.Product;

/**
 *
 * @author kalle
 */
public class ProductButton extends JButton {
    
    private Product product;

    public ProductButton(Product product) {
        super(product.getDisplayName());
        this.product = product;        
    }

    public Product getProduct() {
        return product;
    }
    
    
    
}
