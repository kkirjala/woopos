/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import controller.OrderController;
import interfaces.PaymentMethod;
import interfaces.PosBackend;
import interfaces.PosUI;
import java.util.List;

/**
 * Main Application class that will take care of instantiation of the
 * needed objects and fire it all up.
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

    /**
     * Empty constructor.
     */
    public WooPOS() {

        /* TODO:
         - parse config file
         - get backend w/ login credentials
         - get payment methods
        
         - call constructor: this(backend, ui, paymentMethods);
         */
        
        
    }

    /**
     * Fire up the application.
     * @param backend the backend database to be used for storing information.
     * @param ui User interface class
     * @param paymentMethods the allowed/used payment methods.
     */
    public WooPOS(PosBackend backend, PosUI ui, List<PaymentMethod> paymentMethods) {

        this.backend = backend;
        this.ui = ui;
        this.paymentMethods = paymentMethods;
        
        
        this.orderController = new OrderController(this);        

        fireOnPosStartup();

        // TODO: wait for the UI to close
        fireOnPosClose();

    }

    /**
     * Firing of the application start event.
     */
    public void fireOnPosStartup() {

        this.backend.onPosStartup(this);

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosStartup(this);
        }
        
        this.ui.onPosStartup(this);
        
        this.orderController.onPosStartup(this);

    }

    /**
     * Fire the application close event.
     */
    public void fireOnPosClose() {

        this.backend.onPosClose(this);

        for (PaymentMethod currPaymentMethod : this.paymentMethods) {
            currPaymentMethod.onPosClose(this);
        }
        
        this.ui.onPosClose(this);
        
        this.orderController.onPosClose(this);

    }

    /**
     * Returns a reference to the used database backend.
     * @return backend
     */
    public PosBackend getBackend() {
        return backend;
    }

    /**
     * Returns the payment methods used at the runtime.
     * @return a list of PaymentMethod objects
     */
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * Returns a reference to the used User Interface.
     * @return PosUI
     */
    public PosUI getUi() {
        return ui;
    }

    /**
     * Returns a reference to the controller object for manipulating shopping
     * cart, products and orders.
     * @return OrderController
     */
    public OrderController getOrderController() {
        return orderController;
    }
    
    

}
