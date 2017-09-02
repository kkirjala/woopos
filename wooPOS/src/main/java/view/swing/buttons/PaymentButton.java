package view.swing.buttons;

import interfaces.PaymentMethod;
import javax.swing.JButton;

/**
 * A custom button class for creating buttons that trigger making Payments
 * for Orders.
 * @author kkirjala
 */
public class PaymentButton extends JButton {

    private PaymentMethod paymentMethod;

    /**
     * Create a new button.
     * @param paymentMethod the PaymentMethod that will be triggered by this
     * button.
     */
    public PaymentButton(PaymentMethod paymentMethod) {

        super(paymentMethod.getDisplayName());

        this.paymentMethod = paymentMethod;
        this.setActionCommand("create_payment");

    }

    /**
     * The PaymentMethod associated with this button.
     * @return the PaymentMethod.
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

}
