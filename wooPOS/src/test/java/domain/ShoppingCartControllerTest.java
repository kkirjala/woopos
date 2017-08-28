/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import controller.ShoppingCartController;
import model.ShoppingCart;
import model.Product;
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
public class ShoppingCartControllerTest {

    private ShoppingCartController controller;
    private ShoppingCart cart;

    public ShoppingCartControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.controller = new ShoppingCartController();
        this.cart = controller.createShoppingCart();

    }

    @After
    public void tearDown() {

        this.cart = null;

    }

    @Test
    public void testAddProduct() {
        System.out.println("addProduct");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);

        controller.addProduct(cart, firstProduct);

        // TODO: 
        // add product. add second product, check price
        assertEquals(2, cart.getTotalPrice(), 0.0);

        controller.addProduct(cart, secondProduct);

        assertEquals(12, cart.getTotalPrice(), 0.0);

    }

    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);

        controller.addProduct(cart, firstProduct);
        controller.addProduct(cart, secondProduct);

        assertEquals(12.0, cart.getTotalPrice(), 0.0);

        controller.removeProduct(cart, secondProduct);

        assertEquals(2.0, cart.getTotalPrice(), 0.0);

        controller.removeProduct(cart, firstProduct);

        assertEquals(0.0, cart.getTotalPrice(), 0.0);

    }

    @Test
    public void testApplyDiscountPercentage() {
        System.out.println("applyDiscountPercentage");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);

        cart.addProduct(firstProduct);
        cart.addProduct(secondProduct);

        // 0% discount?
        controller.applyDiscountPercentage(cart, 0);

        assertEquals(12.0, cart.getTotalPrice(), 0.0);

        // 50% discount?
        controller.applyDiscountPercentage(cart, 50);

        assertEquals(6.0, cart.getTotalPrice(), 0.0);

    }

    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");

        assertEquals(0, cart.getTotalPrice(), 0.0);

    }

    @Test
    public void testGetProducts() {
        System.out.println("getProducts");

        Product firstProduct = new Product("First Product", 2);
        Product secondProduct = new Product("Second Product", 10);
        Product thirdProduct = new Product("Third product", 50);

        controller.addProduct(cart, thirdProduct);
        controller.addProduct(cart, secondProduct);
        controller.addProduct(cart, firstProduct);

        List<Product> actualProducts = cart.getProducts();
        assertEquals(3, actualProducts.size());

    }

    @Test
    public void testAddShoppingCartListener() {

        // TODO: opettele tekemään eventtikuuntelijan yksikkötesti
    }

}
