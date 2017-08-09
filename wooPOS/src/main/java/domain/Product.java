package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kkirjala
 */
public class Product {
    
    private final String displayName;
    private final int price;

    public Product(String displayName, int price) {
        this.displayName = displayName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getDisplayName() {
        return displayName;
    }                
    
}
