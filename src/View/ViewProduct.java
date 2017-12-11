package View;

import Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by cderienzo on 12/9/2017.
 */
public class ViewProduct {
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
    private JTextPane description;
    private JTextField thumbnail;
    private JTextField precio;
    private JTextField name;
    private JButton verOpinionesButton;
    private JLabel rating;
    private JLabel stock;
    private JLabel visitas;
    private Product product;

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
    public JPanel getMainpanel() {
        return mainpanel;
    }

    public void printProduct(Product product){
        cleanProduct();
        name.setText(product.getName());
        precio.setText("$" + ((Double)product.getPrice()).toString());
        description.setText(product.getDescription());
        this.product = product;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        visitas.setText("Visitas: "+product.getVisits()+"               ");
        stock.setText("Quedan " + product.getStock() + " unidades                        ");
        rating.setText("Puntaje: " + (df.format(product.getRating())) + "/5               ");
    }

    public void cleanProduct(){
        name.setText("");
        precio.setText("");
        description.setText("");
        stock.setText("");
        rating.setText("");
        visitas.setText("");
    }

    public JButton getREVIEWSButton(){
        return verOpinionesButton;
    }

}
