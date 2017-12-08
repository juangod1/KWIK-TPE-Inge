package View;

import Controller.Controller;
import Model.Product;
import Model.User;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
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
    private JList list1;
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
        System.out.println(table1);
        String[] columns = {"Artículo", "Categoría", "Precio", "Dias Restantes", "Fecha"};
        Object[][] data = new Object[3][5];
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(Product.create("Manzana","esta medio podrida", 666.0, User.get(0), "thumbnail", 4));
        prods.add(Product.create("Tornillo","lo encontre en mi cajon", 5.0, User.get(0), "thumbnail", 7));
        prods.add(Product.create("Tornillo","lo encontre en mi cajon", 5.0, User.get(0), "thumbnail", 7));

        int row,col;
        for (row=0;row<3;row++){
            for (col=0;col<3;col++){
                switch (col){
                    case 0:
                        data[row][col] = prods.get(row).getName();
                        break;
                    case 1:
                        data[row][col] = "Category is no more";
                        break;
                    case 2:
                        data[row][col] = prods.get(row).getPrice();
                        break;
                }

            }
        }
    }
}
