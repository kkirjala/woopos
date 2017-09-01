/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import controller.OrderController;
import controller.OrderController;
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
    private OrderController orderController;
    private OrderController shoppingCartController;

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
        
        this.orderController = new OrderController();
        this.shoppingCartController = new OrderController(this);        

        fireOnPosStartup();

        // TODO: wait for the UI to close
        fireOnPosClose();

    }

    public void fireOnPosStartup() {

        this.backend.onPosStartup(this);

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosStartup(this);
        }
        
        this.ui.onPosStartup(this);
        
        this.shoppingCartController.onPosStartup(this);

    }

    public void fireOnPosClose() {

        this.backend.onPosClose(this);

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosClose(this);
        }
        
        this.ui.onPosClose(this);
        
        this.shoppingCartController.onPosClose(this);

    }

    public PosBackend getBackend() {
        return backend;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public PosUI getUi() {
        return ui;
    }

}
