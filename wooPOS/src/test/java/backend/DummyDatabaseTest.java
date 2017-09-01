/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import application.WooPOS;
import controller.ShoppingCartController;
import java.util.List;
import model.Order;
import model.Product;
import model.ShoppingCart;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kalle
 */
public class DummyDatabaseTest {
    
    private DummyDatabase db;
    
    public DummyDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.db = new DummyDatabase();
        this.db.onPosStartup(new WooPOS());
    }
    
    @After
    public void tearDown() {
        this.db.onPosClose(new WooPOS());
    }

 
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        
        List<Product> products = this.db.getProducts();
        assertEquals(20, products.size());
    }

    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        
        int origSize = this.db.getProducts().size();
        
        this.db.addProduct(new Product("Product 1", 15.0));
        
        assertEquals(origSize + 1, this.db.getProducts().size());
    }

    /**
     * Test of deleteProduct method, of class DummyDatabase.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        
        int origSize = this.db.getProducts().size();
        Product prod = new Product("Product 1", 15.0);
        
        
        this.db.addProduct(prod);
        
        assertEquals(origSize + 1, this.db.getProducts().size());
        
        this.db.deleteProduct(prod);
        
        assertEquals(origSize, this.db.getProducts().size());
    }

    @Test
    public void testCreateOrder() {
        System.out.println("createOrder");
        
        ShoppingCartController cartController = new ShoppingCartController(new WooPOS());
        ShoppingCart cart = cartController.getShoppingCart();
        
        cartController.addProduct(cart, new Product("Product 1", 15.0));
        
        Order testOrder = this.db.createOrder(cart);
             
        assertNotEquals(null, testOrder);

    }

    @Test
    public void testGetOrder() {
        // TODO
        assertEquals(0, 0);
    }
    
}
