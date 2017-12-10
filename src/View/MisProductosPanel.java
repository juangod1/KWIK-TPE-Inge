package View;

import Controller.Controller;
import Model.Product;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class MisProductosPanel {
    private Controller controller;
    private JPanel mainpanel;
    private JPanel header;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JLabel KWIKlabel;
    private JButton CARRITObutton;
    private JPanel footnote;
    private JPanel middle;
    private JButton SEARCHbutton;
    private JLabel resultsLabel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton viewButton;
    private JButton viewButton1;
    private JButton viewButton2;
    private JButton viewButton3;
    private JButton viewButton4;
    private ArrayList<JTextArea> textAreas;
    private Iterator<Product> productIterator;
    private ArrayList<JButton> buttons;
    private View view;


    public MisProductosPanel(Controller controller){
        this.view=controller.getView();
        this.controller=controller;
        textAreas= new ArrayList<>();
        textAreas.add(textArea1);textAreas.add(textArea2);textAreas.add(textArea3);textAreas.add(textArea4);textAreas.add(textArea5);
        productIterator=null;
        buttons= new ArrayList<>();
        buttons.add(viewButton);buttons.add(viewButton1);buttons.add(viewButton2);buttons.add(viewButton3);buttons.add(viewButton4);
    }
    public void printItems(){
        clearItems();
        if(productIterator==null) {
            User user = controller.getCurrentUser();
            if(user!=null) {
                ArrayList<Product> list = Product.getByUser(user);
                productIterator=(!list.isEmpty())?list.iterator():null;
            }
        }
        if(productIterator!=null) {
            Iterator<JButton> buttonIterator = buttons.iterator();
            Iterator<JTextArea> jTextAreaIterator = textAreas.iterator();
            for (int i = 0; i < 5 && productIterator.hasNext(); i++) {
                final Product curr = productIterator.next();
                JButton currButton = buttonIterator.next();
                jTextAreaIterator.next().setText(curr.getName() + "    -    " + curr.getPrice() + "    -    " + curr.getVisits());
                currButton.setVisible(true);

                currButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        view.viewProduct.printProduct(curr);
                        view.cardLayout=(CardLayout)view.cards.getLayout();
                        view.cardLayout.show(view.cards, "viewProductPanel");
                        view.cards.revalidate();
                    }
                });
            }
            if (!productIterator.hasNext()) {
                productIterator = null;
            }
        }
    }
    private void clearItems(){
        Iterator<JButton> buttonIterator = buttons.iterator();
        for (JTextArea jTextArea: textAreas){
            jTextArea.setText("");
            buttonIterator.next().setVisible(false);
        }
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
}
