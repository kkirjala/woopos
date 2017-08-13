/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import interfaces.PaymentMethod;
import interfaces.PosBackend;
import java.util.List;

/**
 *
 * @author kkirjala
 */
public class WooPOS {

    /* todo:
     - init backend/database
     - init paymentmethods
     - init ui/gui
    
     */
    private List<PosBackend> backends;
    private List<PaymentMethod> paymentMethods;

    public WooPOS() {
        
        /* TODO:
        - parse config file
        - get backend w/ login credentials
        - get payment methods
        */

        fireOnPosStartup();
        
        // TODO: wait for the UI to close
        
        fireOnPosClose();

    }

    public void fireOnPosStartup() {

        for (PosBackend currBackend : this.backends) {
            currBackend.onPosStartup();
        }

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosStartup();
        }

    }

    public void fireOnPosClose() {
        
        for (PosBackend currBackend : this.backends) {
            currBackend.onPosClose();
        }

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosClose();
        }

    }

}