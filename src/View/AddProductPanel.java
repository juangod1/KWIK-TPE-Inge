package View;

import Controller.Controller;
import Model.Product;
import Model.User;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;


/**
 * Created by cderienzo on 12/9/2017.
 */
public class AddProductPanel {
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
    private JTextField nombre;
    private JTextField cantidad;
    private JTextPane descripcion;
    private JTextField precio;
    private JButton foto2;
    private JButton foto1;
    private JButton publishButton;
    private JButton cancelButton;
    private View.ViewSwapper vs;


    public AddProductPanel(final View.ViewSwapper vs) {
        this.vs = vs;
        foto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        foto2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        publishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nombre.getText();
                Double price = Double.parseDouble(precio.getText());
                Integer stock = Integer.parseInt(cantidad.getText());
                String description = descripcion.getText();
                User user = Controller.getInstance().getModel().getUser();
                Product product = Product.create(name,description,price,user,"thumbnail",stock);
                if(product!=null){
                    JOptionPane.showMessageDialog(null,"El producto fue publicado");
                    vs.changeView("profileMenuPanel",null);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Hubo un error");
                    vs.changeView("profileMenuPanel",null);

                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("profilePanel",null);
            }
        });
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
    public JPanel getMainpanel() {
        return mainpanel;
    }
}
