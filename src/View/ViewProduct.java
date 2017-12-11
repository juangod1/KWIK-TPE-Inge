package View;

import Model.Cart;
import Model.Product;
import Controller.Controller;
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
    private JLabel precio;
    private JTextField name;
    private JButton verOpinionesButton;
    private JLabel rating;
    private JLabel stock;
    private JLabel vendidos;
    private JButton addToCartButton;
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

        if(addToCartButton.getActionListeners().length > 0) {
            addToCartButton.removeActionListener(addToCartButton.getActionListeners()[0]);
        }
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Controller.getInstance().getCurrentUser()==null) {
                    JOptionPane.showMessageDialog(null, "No esta loggeado");
                    return;
                }
                Cart.getOrCreate(Controller.getInstance().getCurrentUser()).addProduct(product,1);
                JOptionPane.showMessageDialog(null,"El producto fue agregado al carrito con exito");
            }
        });

        description.setText(product.getDescription());
        vendidos.setText(product.getSold()+" Unidades vendidas");
        this.product = product;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        stock.setText("Quedan " + product.getStock() + " unidades                        ");
        rating.setText("Puntaje: " + (df.format(product.getRating())) + "/5               ");
    }

    public void cleanProduct(){
        name.setText("");
        precio.setText("");
        description.setText("");
        stock.setText("");
        rating.setText("");
        vendidos.setText("");
    }

    public JButton getREVIEWSButton(){
        return verOpinionesButton;
    }

}
