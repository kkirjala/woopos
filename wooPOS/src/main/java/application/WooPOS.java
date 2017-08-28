/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import interfaces.PaymentMethod;
import interfaces.PosBackend;
import interfaces.PosUI;
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
    private PosBackend backend;
    private PosUI ui;
    private List<PaymentMethod> paymentMethods;

    public WooPOS() {

        /* TODO:
         - parse config file
         - get backend w/ login credentials
         - get payment methods
        
         - call constructor: this(backend, ui, paymentMethods);
         */
        
        
    }

    public WooPOS(PosBackend backend, PosUI ui, List<PaymentMethod> paymentMethods) {

        this.backend = backend;
        this.ui = ui;
        this.paymentMethods = paymentMethods;

        fireOnPosStartup();

        // TODO: wait for the UI to close
        fireOnPosClose();

    }

    public void fireOnPosStartup() {

        this.backend.onPosStartup();

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosStartup();
        }

    }

    public void fireOnPosClose() {

        this.backend.onPosClose();

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosClose();
        }

    }

}
