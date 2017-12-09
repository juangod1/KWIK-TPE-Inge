package View;

import Controller.Controller;
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

    public void printResults(String query){

        ArrayList<Product> prods = new ArrayList<>();
        prods.add(Product.create("Manzana","esta medio podrida", 666.0, User.get(0), "thumbnail", 4));
        prods.add(Product.create("Tornillo","lo encontre en mi cajon", 5.0, User.get(0), "thumbnail", 7));
        prods.add(Product.create("Tornillo","lo encontre en mi cajon", 5.0, User.get(0), "thumbnail", 7));

        textArea1.setText(prods.get(0).getName() + "              -              $" + prods.get(0).getPrice());
        textArea2.setText(prods.get(1).getName() + "              -              $" + prods.get(1).getPrice());
        textArea3.setText(prods.get(2).getName() + "              -              $" + prods.get(2).getPrice());
        textArea4.setText(prods.get(3).getName() + "              -              $" + prods.get(3).getPrice());
        textArea5.setText(prods.get(4).getName() + "              -              $" + prods.get(4).getPrice());

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("asdfasdf");
            }
        });
     }
}
