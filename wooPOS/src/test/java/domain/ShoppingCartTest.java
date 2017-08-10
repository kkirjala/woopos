/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kkirjala
 */
public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    public ShoppingCartTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.shoppingCart = new ShoppingCart();

    }

    @After
    public void tearDown() {

        this.shoppingCart = null;

    }

    @Test
    public void testAddProduct() {
        System.out.println("addProduct");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);

        shoppingCart.addProduct(firstProduct);

        // TODO: 
        // add product. add second product, check price
        assertEquals(2, shoppingCart.getTotalPrice(), 0.0);

        shoppingCart.addProduct(secondProduct);

        assertEquals(12, shoppingCart.getTotalPrice(), 0.0);

    }

    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);

        shoppingCart.addProduct(firstProduct);
        shoppingCart.addProduct(secondProduct);

        assertEquals(12.0, shoppingCart.getTotalPrice(), 0.0);

        shoppingCart.removeProduct(secondProduct);

        assertEquals(2.0, shoppingCart.getTotalPrice(), 0.0);

        shoppingCart.removeProduct(firstProduct);

        assertEquals(0.0, shoppingCart.getTotalPrice(), 0.0);

    }

    @Test
    public void testApplyDiscountPercentage() {
        System.out.println("applyDiscountPercentage");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);

        shoppingCart.addProduct(firstProduct);
        shoppingCart.addProduct(secondProduct);

        // 0% discount?
        shoppingCart.applyDiscountPercentage(0);

        assertEquals(12.0, shoppingCart.getTotalPrice(), 0.0);

        // 50% discount?
        shoppingCart.applyDiscountPercentage(50);

        assertEquals(6.0, shoppingCart.getTotalPrice(), 0.0);

    }

    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");

        assertEquals(0, shoppingCart.getTotalPrice(), 0.0);

    }

    @Test
    public void testGetProducts() {
        System.out.println("getProducts");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);
        Product thirdProduct = new Product("Third product", 50);

        shoppingCart.addProduct(thirdProduct);
        shoppingCart.addProduct(secondProduct);
        shoppingCart.addProduct(firstProduct);

        List<Product> actualProducts = shoppingCart.getProducts();
        assertEquals(3, actualProducts.size());

    }

    @Test
    public void testAddShoppingCartListener() {

        // TODO: opettele tekemään eventtikuuntelijan yksikkötesti
    }

}
