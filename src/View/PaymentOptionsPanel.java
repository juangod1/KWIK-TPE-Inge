package View;

import Model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentOptionsPanel {
    private JPanel footnote;
    private JPanel header;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JLabel KWIKlabel;
    private JButton CARRITObutton;
    private JButton SEARCHbutton;
    private JPanel middle;
    private JLabel loginLabel;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JButton newCardButton;
    private JComboBox cardSelector;
    private JPanel mainpanel;
    private JButton confirmPaymentButton;
    private View.ViewSwapper vs;

    public PaymentOptionsPanel(final View.ViewSwapper vs){
        this.vs = vs;
//        for(Card card : ){
//            cardSelector.addItem()
//        }
        confirmPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card card = getCard();
                if(card == null){
                    JOptionPane.showMessageDialog(mainpanel,
                            "Se debe seleccionar una tarjeta.",
                            "",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //pay with Card y decirle a controller que vacie el carrito
                }
            }
        });

        newCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCardCreator();
            }
        });

        EQUIPObutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("teamPanel");
            }
        });

        VISIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //vs.changeView("visionPanel");
                JOptionPane.showMessageDialog(null,"Vision under development");
            }
        });

        PERFILButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("profilePanel");
            }
        });

        CARRITObutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("shoppingcartPanel");
            }
        });

        SEARCHbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("searchPanel"); }
        });
    }

    private static void displayCardCreator() {
        JTextField name = new JTextField();
        JTextField surname = new JTextField();
        JTextField number = new JTextField();
        JTextField day = new JTextField();
        JTextField month = new JTextField();
        JTextField code = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(name);
        panel.add(new JLabel("Surname:"));
        panel.add(surname);
        panel.add(new JLabel("Expiration day:"));
        panel.add(day);
        panel.add(new JLabel("Expiration month:"));
        panel.add(month);
        panel.add(new JLabel("Credit card number:"));
        panel.add(number);
        panel.add(new JLabel("security Code:"));
        panel.add(code);
        int result = JOptionPane.showConfirmDialog(null, panel, "nueva tarjeta",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            //retrieve fields and send to model
        } else {
            System.out.println("Cancelled");
        }
    }

    public Card getCard() {
        return (Card)cardSelector.getSelectedItem();
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

}
