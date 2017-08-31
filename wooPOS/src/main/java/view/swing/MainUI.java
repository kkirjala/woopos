/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.swing;

import application.WooPOS;
import backend.DummyDatabase;
import interfaces.PosUI;
import interfaces.ShoppingCartListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.Product;
import model.ShoppingCart;

/**
 *
 * @author kalle
 */
public class MainUI implements PosUI {

    private WooPOS app;
    
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    
    
    private JPanel productButtonPanel;
    private JPanel shoppingCartPanel;
    private JTextArea shoppingCartTextArea;
    
    private ShoppingCart shoppingCart;

    public MainUI() {
        prepareGUI();

    }

    private void prepareGUI() {
        mainFrame = new JFrame("wooPOS");
        mainFrame.setSize(1024, 768);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        productButtonPanel = new JPanel();
        productButtonPanel.setLayout(new GridLayout(10, 5));

        shoppingCartPanel = new JPanel();
        shoppingCartPanel.setLayout(new FlowLayout());
        shoppingCartTextArea = new JTextArea();
        shoppingCartTextArea.setText("initial text");
        
        
        
        mainFrame.add(headerLabel);
        mainFrame.add(productButtonPanel);
        mainFrame.add(shoppingCartPanel);
        mainFrame.add(statusLabel);
        
    }

    private void showEventDemo() {
        headerLabel.setText("Control in action: Button");

        DummyDatabase db = new DummyDatabase();
        ArrayList<ProductButton> prodButtons = new ArrayList<>();
        
        for (Product currProduct : db.getProducts()) {
            prodButtons.add(new ProductButton(currProduct));
                    
            ProductButton btn = prodButtons.get(prodButtons.size() - 1);

            btn.setActionCommand(currProduct.getDisplayName());
            btn.addActionListener(new ProductButtonClickListener());

        }
        
        for (ProductButton currButton : prodButtons) {
            productButtonPanel.add(currButton);
        }

        
        mainFrame.setVisible(true);
    }

    @Override
    public void onPosStartup(WooPOS applicationContext) {
        
        MainUI swingControlDemo = new MainUI();
        swingControlDemo.showEventDemo();
        
        
    }

    @Override
    public void onPosClose(WooPOS applicationContext) {

    }

    private class ProductButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            ProductButton prodButton = (ProductButton) e.getSource();
            Product prod = prodButton.getProduct();

            statusLabel.setText(prod.getDisplayName() + " clicked!");
        }
    }

    private class ShoppingCartRefresher implements ShoppingCartListener {

        public void onShoppingCartUpdated(ShoppingCart cart) {
            shoppingCartTextArea.setText(cart.getProducts().toString());
        }
        
    }

}
