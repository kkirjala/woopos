/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author kkirjala
 */
public class Payment {
    
    private Order order;
    private double amount;
    private String description;

    public Payment(Order order, double amount, String description) {
        this.order = order;
        this.amount = amount;
        this.description = description;
    }
    
}
