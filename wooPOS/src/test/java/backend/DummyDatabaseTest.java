/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import application.WooPOS;
import interfaces.PosBackend;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.dummy.DummyView;

/**
 *
 * @author kalle
 */
public class DummyDatabaseTest {
    
    private WooPOS app;
    private PosBackend db;
    
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
        this.app = new WooPOS(new DummyDatabase(), new DummyView(), new ArrayList<>());
        this.db = this.app.getBackend();
    }
    
    @After
    public void tearDown() {
        this.app.getBackend().onPosClose(this.app);
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
    public void testGetOrder() {
        // TODO
        assertEquals(0, 0);
    }
    
}
