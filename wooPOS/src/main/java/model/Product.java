package model;


/**
 * Product class.
 * @author kkirjala
 */
public class Product {
    
    private final String displayName;
    private final double price;

    /**
     * Create a new product.
     * @param displayName a friendly name to be displayed in UI.
     * @param price the price including taxes.
     */
    public Product(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    /**
     * Returns the price.
     * @return price (a double).
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the friendly/display name.
     * @return the name (a string).
     */
    public String getDisplayName() {
        return displayName;
    }                
    
}
