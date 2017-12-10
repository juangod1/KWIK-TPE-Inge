package View;

import Controller.Controller;
import Model.Cart;
import Model.Product;
import View.View.CartSwapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class ShoppingcartPanel {
    private JPanel mainpanel;
    private JPanel header;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JLabel KWIKlabel;
    private JButton CARRITObutton;
    private JButton SEARCHbutton;
    private JPanel footnote;
    private JPanel middle;
    private JTextArea total;
    private JButton checkoutButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextArea textArea;
    private View.ViewSwapper vs;
    private Controller controller;
    private Cart cart;
    private CartSwapper cs;


    public ShoppingcartPanel(final View.ViewSwapper vs, Controller controller, final CartSwapper cs) {
        this.vs = vs;
        this.cs = cs;
        this.controller = controller;

        mainpanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                writeCart();
            }
        });
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object[] options = {"Pagar con tarjeta",
                        "Cancelar"};
                int n = JOptionPane.showOptionDialog(mainpanel,
                        "como desea proceder?",
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
                if( n == JOptionPane.YES_OPTION){
                    if(cart != null && cart.getProducts().size() > 0) {
                        vs.changeView("paymentOptionsPanel", null);
                        System.out.println("Sent to payment with cart:"+cart.getId());
                        cs.swapCard(cart);


                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No hay articulos en el carrito");
                    }
                }


            }
        });
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public JButton getSEARCHbutton() {
        return SEARCHbutton;
    }

    public JButton getCARRITObutton() {
        return CARRITObutton;
    }

    public JButton getPERFILButton() {
        return PERFILButton;
    }

    public JButton getVISIONButton() {
        return VISIONButton;
    }

    public JButton getEQUIPObutton() {
        return EQUIPObutton;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
    public void write(String string){
        System.out.println(string);
        textArea.append(string);
    }

    public void writeCart(){
        if(controller.getCurrentUser()!=null) {

            this.cart = Cart.getUserCart(controller.getCurrentUser());
            cleanCart();

            if (cart != null) {

                if (cart.getProducts().size() >= 1) {
                    textArea1.setText(cart.getProducts().get(0).getName());
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cart.removeProduct(cart.getProducts().get(0));
                            writeCart();
                        }
                    });
                }
                else
                    textArea1.setText("");

                if (cart.getProducts().size() >= 2) {
                    textArea2.setText(cart.getProducts().get(1).getName());
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cart.removeProduct(cart.getProducts().get(1));
                            writeCart();
                        }
                    });
                }

                else
                    textArea2.setText("");

                if (cart.getProducts().size() >= 3) {
                    textArea3.setText(cart.getProducts().get(2).getName());
                    button3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cart.removeProduct(cart.getProducts().get(2));
                            writeCart();
                        }
                    });
                }
                else
                    textArea3.setText("");

                if (cart.getProducts().size() >= 4) {
                    textArea4.setText(cart.getProducts().get(3).getName());
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cart.removeProduct(cart.getProducts().get(3));
                            writeCart();
                        }
                    });
                }
                else
                    textArea4.setText("");

                double moneh = 0;
                for (Product p : cart.getProducts()) {
                    moneh += p.getPrice();
                }

                total.setText("The total is:    $" + moneh);
            }
        }
        else
            total.setText("There is no cart");
    }

    public void cleanCart(){
        textArea1.setText("");
        textArea2.setText("");
        textArea3.setText("");
        textArea4.setText("");
        total.setText("");

        if(button1.getActionListeners().length>0)
        button1.removeActionListener(button1.getActionListeners()[0]);
        if(button2.getActionListeners().length>0)
        button2.removeActionListener(button2.getActionListeners()[0]);
        if(button3.getActionListeners().length>0)
        button3.removeActionListener(button3.getActionListeners()[0]);
        if(button4.getActionListeners().length>0)
        button4.removeActionListener(button4.getActionListeners()[0]);
    }
}
