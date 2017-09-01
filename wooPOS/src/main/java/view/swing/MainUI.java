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
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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

    private List<ProductButton> productButtons;

    public MainUI() {

        this.productButtons = new ArrayList<>();

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
        
        shoppingCartTextArea = new JTextArea("shopping cart display");
        shoppingCartTextArea.setSize(300, 600);
        shoppingCartTextArea.setBackground(Color.WHITE);
        
        shoppingCartPanel.add(shoppingCartTextArea);

        mainFrame.add(headerLabel);
        mainFrame.add(productButtonPanel);
        mainFrame.add(shoppingCartPanel);
        mainFrame.add(statusLabel);

    }

    private void showEventDemo() {
        headerLabel.setText("wooPOS");

        
    }
    
    @Override
    public void onPosStartup(WooPOS applicationContext) {

        MainUI swingControlDemo = new MainUI();
        swingControlDemo.showEventDemo();

    }

    @Override
    public void onPosClose(WooPOS applicationContext) {

    }

    @Override
    public void generateProductButtons(List<Product> products, ActionListener listener) {
        
        for (Product currProduct : products) {
            this.productButtons.add(new ProductButton(currProduct));

            ProductButton btn = this.productButtons.get(this.productButtons.size() - 1);

            btn.setActionCommand(currProduct.getDisplayName());
            btn.addActionListener(listener);

        }

        for (ProductButton currButton : this.productButtons) {
            productButtonPanel.add(currButton);
        }
        
        mainFrame.setVisible(true);
        
    }


    @Override
    public void setShoppingCartContentDisplay(ShoppingCart cart) {
        
        String cartContents = "";
        
        for (Product currProduct : cart.getProducts()) {
            cartContents += currProduct.getDisplayName() + " (" + new DecimalFormat("#.##").format(currProduct.getPrice()) + ")" + "\n";
        }

        cartContents += "\n---\n" + new DecimalFormat("#.##").format(cart.getTotalPrice());
        
        
        this.shoppingCartTextArea.setText(cartContents);
    }

}
