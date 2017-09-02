package model;

/**
 * Payment class for payments of Orders.
 *
 * @author kkirjala
 */
public class Payment {

    private double amount;
    private String description;

    /**
     * Create a new Payment.
     *
     * @param amount the amount that was paid.
     * @param description a free-form description of the transaction, f.ex. a
     * reference to the transaction ID.
     */
    public Payment(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    /**
     * Amount of Payment.
     * @return amount of Payment.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Description.
     * @return description of the transaction or a transaction ID. Free-form.
     */
    public String getDescription() {
        return description;
    }

}
