/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kkirjala
 */
public class Payment {
    
    private double amount;
    private String description;

    public Payment(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }
    
}
