package View;

import Controller.Controller;
import Model.Product;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton removerButton;
    private JButton removerButton1;
    private JButton removerButton2;
    private JButton removerButton3;
    private JButton removerButton4;
    private ArrayList<JTextArea> textAreas;
    private Iterator<Product> productIterator;
    private ArrayList<JButton> viewButtons;
    private ArrayList<JButton> removeButtons;
    private View view;


    public MisProductosPanel(Controller controller, View view){
        this.view = view;
        this.controller=controller;
        textAreas= new ArrayList<>();
        textAreas.add(textArea1);textAreas.add(textArea2);textAreas.add(textArea3);textAreas.add(textArea4);textAreas.add(textArea5);
        productIterator=null;
        viewButtons = new ArrayList<>();
        viewButtons.add(viewButton);viewButtons.add(viewButton1);viewButtons.add(viewButton2);viewButtons.add(viewButton3);
        viewButtons.add(viewButton4);
        removeButtons= new ArrayList<>();
        removeButtons.add(removerButton);removeButtons.add(removerButton1);removeButtons.add(removerButton2);removeButtons.add(removerButton3);
        removeButtons.add(removerButton4);
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
            Iterator<JButton> viewButtonIterator = viewButtons.iterator();
            Iterator<JButton> removeButtonIterator = removeButtons.iterator();
            Iterator<JTextArea> jTextAreaIterator = textAreas.iterator();
            for (int i = 0; i < 5 && productIterator.hasNext(); i++) {
                final Product curr = productIterator.next();
                JButton currViewButton = viewButtonIterator.next();
                JButton currRemoveButton = removeButtonIterator.next();
                jTextAreaIterator.next().setText(curr.getName() + "    -    " + curr.getPrice() + "    -    " + curr.getVisits());
                currViewButton.setVisible(true);
                currRemoveButton.setVisible(true);

                currRemoveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        curr.delete();
                        curr.save();
                        JOptionPane.showMessageDialog(null, "Producto eliminado!");
                    }
                });
                currViewButton.addActionListener(new ActionListener() {
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
        Iterator<JButton> viewButtonIterator = viewButtons.iterator();
        Iterator<JButton> removeButtonIterator = removeButtons.iterator();
        JButton currView;
        JButton currRemove;
        for (JTextArea jTextArea: textAreas){
            jTextArea.setText("");
            currRemove=removeButtonIterator.next();
            currView=viewButtonIterator.next();
            currRemove.setVisible(false);
            currView.setVisible(false);
            if(currRemove.getActionListeners().length!=0){
                currRemove.removeActionListener(currRemove.getActionListeners()[0]);
            }
            if(currView.getActionListeners().length!=0){
                currView.removeActionListener(currView.getActionListeners()[0]);
            }
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
