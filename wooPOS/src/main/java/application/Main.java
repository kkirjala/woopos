/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import backend.DummyDatabase;
import java.util.ArrayList;
import view.swing.MainUI;

/**
 *
 * @author kkirjala
 */
public class Main {

    public static void main(String[] args) {
        // application entrypoint

        WooPOS pos = new WooPOS(new DummyDatabase(), new MainUI(), new ArrayList<>());
        
    }

}
