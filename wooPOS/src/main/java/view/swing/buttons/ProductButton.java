package view.swing.buttons;

import javax.swing.JButton;
import model.Product;

/**
 * A custom button class for making buttons that add Products to ShoppingCart.
 * @author kalle
 */
public class ProductButton extends JButton {

    private Product product;

    /**
     * Create a new Button.
     * @param product the Product associated with this button.
     */
    public ProductButton(Product product) {

        super(product.getDisplayName());

        this.product = product;
        this.setActionCommand("add_product_to_cart");

    }

    /**
     * Return the Product associated with this button.
     * @return the Product.
     */
    public Product getProduct() {
        return product;
    }

}
