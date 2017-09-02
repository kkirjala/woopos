/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import backend.DummyDatabase;
import interfaces.PaymentMethod;
import java.util.ArrayList;
import paymentmethods.Cash;
import view.swing.MainUI;

/**
 * Main class for the app.
 * @author kkirjala
 */
public class Main {

    /**
     * Application entrypoint.
     * @param args 
     */
    public static void main(String[] args) {

        ArrayList<PaymentMethod> methods = new ArrayList<>();
        methods.add(new Cash());
        
        WooPOS pos = new WooPOS(new DummyDatabase(), new MainUI(), methods);
        
    }

}
