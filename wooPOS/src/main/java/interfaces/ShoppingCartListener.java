package interfaces;

import model.ShoppingCart;

/**
 * Interface specification for listening to changes in a ShoppingCart.
 * @author kkirjala
 */
public interface ShoppingCartListener {

    /**
     * Method that is called everytime the ShoppingCart's contents change.
     * @param shoppingCart that has been updated.
     */
    public void onShoppingCartUpdated(ShoppingCart shoppingCart);

}
