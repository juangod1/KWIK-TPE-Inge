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
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JTable table1;
    private Controller controller;
    private static final int PAGESIZE = 5;
    private int offset;
    private ArrayList<Product> prods;
    private ArrayList<JButton> buttons;

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
        buttons = new ArrayList<>();
        initButtons();

        this.controller = controller;
        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(offset >= PAGESIZE) {
                    offset -= PAGESIZE;
                    siguienteButton.setEnabled(true);
                }
                if(offset < PAGESIZE) {
                    anteriorButton.setEnabled(false);
                }
                refresh();
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = prods.size();
                if(size - offset > PAGESIZE) {
                    offset += PAGESIZE;
                    anteriorButton.setEnabled(true);
                }
                if(size - offset <= PAGESIZE) {
                    siguienteButton.setEnabled(false);
                }
                refresh();
            }
        });
    }

    public void printResults(final ArrayList<Product> prods){
        cleanPanel();
        this.prods = prods;
        offset=0;
        if(prods.size()>PAGESIZE){
            siguienteButton.setEnabled(true);
        }
        refresh();
     }
    private void refresh(){
        cleanPanel();
        Controller.getView().configureSearchView();
        int size = prods.size();
        if(size>=1 + offset) {
            textArea1.setText(prods.get(offset).getName() + "              -              $" + prods.get(offset).getPrice());
            button1.setVisible(true);
            viewButton.setVisible(true);
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(offset),1);
                }
            });
        }
        if(size>=2+offset) {
            textArea2.setText(prods.get(offset+1).getName() + "              -              $" + prods.get(offset+1).getPrice());
            button2.setVisible(true);
            viewButton1.setVisible(true);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(offset+1),1);
                }
            });
        }
        if(size>=3+offset) {
            textArea3.setText(prods.get(offset+2).getName() + "              -              $" + prods.get(offset+2).getPrice());
            button3.setVisible(true);
            viewButton2.setVisible(true);
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(offset+2),1);
                }
            });
        }
        if(size>=4+offset) {
            textArea4.setText(prods.get(offset+3).getName() + "              -              $" + prods.get(offset+3).getPrice());
            button4.setVisible(true);
            viewButton3.setVisible(true);
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(offset+3),1);
                }
            });
        }
        if(size>=5+offset) {
            textArea5.setText(prods.get(offset+4).getName() + "              -              $" + prods.get(offset+4).getPrice());
            button5.setVisible(true);
            viewButton4.setVisible(true);
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getCurrentUser()==null) return;
                    Cart.getOrCreate(controller.getCurrentUser()).addProduct(prods.get(offset+4),1);
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

         for(JButton b : buttons){
             b.setVisible(false);
         }
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

    public void initButtons(){
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);

        buttons.add(viewButton1);
        buttons.add(viewButton2);
        buttons.add(viewButton3);
        buttons.add(viewButton4);
        buttons.add(viewButton);
    }
}
