package View;

import Model.Product;

import javax.swing.*;

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
    private JLabel photo;
    private JLabel photo2;
    private JTextField thumbnail;
    private JTextField precio;
    private JTextField name;

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
        thumbnail.setText(product.getThumbnail());
        precio.setText("$" + ((Double)product.getPrice()).toString());
        description.setText(product.getDescription());
    }

    public void cleanProduct(){
        name.setText("");
        thumbnail.setText("");
        precio.setText("");
        description.setText("");
    }

}
