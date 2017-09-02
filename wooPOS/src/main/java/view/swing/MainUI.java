package view.swing;

import view.swing.panels.ProductButtonPanel;
import view.swing.panels.ShoppingCartPanel;
import view.swing.buttons.ProductButton;
import application.WooPOS;
import interfaces.PaymentMethod;
import interfaces.PosUI;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import view.swing.buttons.PaymentButton;
import view.swing.panels.PaymentButtonPanel;

/**
 * A graphical user interface (GUI) for WooPOS. Made using Java/Swing API.
 * @author kalle
 */
public class MainUI implements PosUI {

    private WooPOS app;

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;

    private ProductButtonPanel productButtonPanel;
    private PaymentButtonPanel paymentButtonPanel;
    private ShoppingCartPanel shoppingCartPanel;
    private JTextArea shoppingCartTextArea;

    private List<ProductButton> productButtons;
    private List<PaymentButton> paymentButtons;

    /**
     * Create a new GUI instance.
     */
    public MainUI() {

        this.productButtons = new ArrayList<>();
        this.paymentButtons = new ArrayList<>();

    }

    /**
     * Do the actual work of creating the individual UI components and placing
     * them in the layout.
     */
    private void initGUI() {

        mainFrame = new JFrame("wooPOS");
        mainFrame.setSize(1024, 768);
        mainFrame.setLayout(new GridLayout(3, 1));

        // TODO: kutsu WooPOS:n sulkurutiinia, joka laukaisee onPosClose-eventin
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        productButtonPanel = new ProductButtonPanel();
        productButtonPanel.setLayout(new GridLayout(10, 5));

        paymentButtonPanel = new PaymentButtonPanel();
        paymentButtonPanel.setLayout(new GridLayout(4, 2));

        shoppingCartPanel = new ShoppingCartPanel();
        shoppingCartPanel.setLayout(new FlowLayout());

        shoppingCartTextArea = new JTextArea("shopping cart display");
        shoppingCartTextArea.setSize(300, 600);
        shoppingCartTextArea.setBackground(Color.WHITE);

        shoppingCartPanel.add(shoppingCartTextArea);

        mainFrame.add(productButtonPanel);
        mainFrame.add(paymentButtonPanel);
        mainFrame.add(shoppingCartPanel);

        mainFrame.setVisible(true);

    }

    @Override
    public void onPosStartup(WooPOS applicationContext) {

        initGUI();

    }

    @Override
    public void onPosClose(WooPOS applicationContext) {

    }

    @Override
    public void generateProductButtons(List<Product> products, ActionListener listener) {

        for (Product currProduct : products) {
            this.productButtons.add(new ProductButton(currProduct));

            ProductButton btn = this.productButtons.get(this.productButtons.size() - 1);

            btn.addActionListener(listener);

        }

        for (ProductButton currButton : this.productButtons) {
            productButtonPanel.add(currButton);
        }

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

    @Override
    public void generatePaymentButtons(List<PaymentMethod> paymentMethods, ActionListener listener) {
        for (PaymentMethod currMethod : paymentMethods) {
            this.paymentButtons.add(new PaymentButton(currMethod));

            PaymentButton btn = this.paymentButtons.get(this.paymentButtons.size() - 1);

            btn.addActionListener(listener);

        }

        for (PaymentButton currButton : this.paymentButtons) {
            paymentButtonPanel.add(currButton);
        }
    }

}
