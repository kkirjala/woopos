/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.swing.buttons;

import interfaces.PaymentMethod;
import javax.swing.JButton;

/**
 *
 * @author kkirjala
 */
public class PaymentButton extends JButton {

    private PaymentMethod paymentMethod;

    public PaymentButton(PaymentMethod paymentMethod) {

        super(paymentMethod.getDisplayName());

        this.paymentMethod = paymentMethod;
        this.setActionCommand("create_payment");

    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

}
