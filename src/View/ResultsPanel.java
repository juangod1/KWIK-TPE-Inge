package View;

import Controller.Controller;
import Model.Cart;
import Model.Product;
import Model.User;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class ResultsPanel {
    private JPanel mainpanel;
    private JPanel header;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JLabel KWIKlabel;
    private JButton CARRITObutton;
    private JPanel footnote;
    private JLabel resultsLabel;
    private JButton SEARCHbutton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton viewButton;
    private JButton viewButton1;
    private JButton viewButton2;
    private JButton viewButton3;
    private JButton viewButton4;
    private JTable table1;
    private Controller controller;

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

    public ResultsPanel(Controller controller){
        this.controller = controller;
        }

    public void printResults(final ArrayList<Product> prods){
        cleanPanel();

        if(prods.size()>=1) {
            textArea1.setText(prods.get(0).getName() + "              -              $" + prods.get(0).getPrice());
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(0),1);
                }
            });
        }
        if(prods.size()>=2) {
            textArea2.setText(prods.get(1).getName() + "              -              $" + prods.get(1).getPrice());
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(1),1);
                }
            });
        }
        if(prods.size()>=3) {
            textArea3.setText(prods.get(2).getName() + "              -              $" + prods.get(2).getPrice());
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(2),1);
                }
            });
        }
        if(prods.size()>=4) {
            textArea4.setText(prods.get(3).getName() + "              -              $" + prods.get(3).getPrice());
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(3),1);
                }
            });
        }
        if(prods.size()>=5) {
            textArea5.setText(prods.get(4).getName() + "              -              $" + prods.get(4).getPrice());
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(4),1);
                }
            });
        }
     }

     private void cleanPanel(){
        textArea1.setText("");
        textArea2.setText("");
        textArea3.setText("");
        textArea4.setText("");
        textArea5.setText("");

        if(viewButton.getActionListeners().length>0)
        viewButton.removeActionListener(viewButton.getActionListeners()[0]);

        if(viewButton1.getActionListeners().length>0)
        viewButton1.removeActionListener(viewButton1.getActionListeners()[0]);

        if(viewButton2.getActionListeners().length>0)
        viewButton2.removeActionListener(viewButton2.getActionListeners()[0]);

         if(viewButton3.getActionListeners().length>0)
        viewButton3.removeActionListener(viewButton3.getActionListeners()[0]);

         if(viewButton4.getActionListeners().length>0)
        viewButton4.removeActionListener(viewButton4.getActionListeners()[0]);


         if(button1.getActionListeners().length>0)
         button1.removeActionListener(button1.getActionListeners()[0]);

         if(button2.getActionListeners().length>0)
         button2.removeActionListener(button2.getActionListeners()[0]);

         if(button3.getActionListeners().length>0)
         button3.removeActionListener(button3.getActionListeners()[0]);

         if(button4.getActionListeners().length>0)
         button4.removeActionListener(button4.getActionListeners()[0]);

         if(button5.getActionListeners().length>0)
         button5.removeActionListener(button5.getActionListeners()[0]);
     }

    public JButton getViewButton() {
        return viewButton;
    }

    public JButton getViewButton1() {
        return viewButton1;
    }

    public JButton getViewButton2() {
        return viewButton2;
    }

    public JButton getViewButton3() {
        return viewButton3;
    }

    public JButton getViewButton4() {
        return viewButton4;
    }
}
