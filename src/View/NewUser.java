package View;

import Controller.InputController;
import Controller.UserCreationStruct;
import jdk.internal.util.xml.impl.Input;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class NewUser {
    private InputController inputController;
    private JPanel mainpanel;
    private JPanel header;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JLabel KWIKlabel;
    private JButton CARRITObutton;
    private JPanel middle;
    private JLabel registrationLabel;
    private JPanel footnote;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel usernameLabel;
    private JLabel addressLabel;
    private JButton SEARCHbutton;
    private JButton crearButton;
    private JLabel mainPhoneLabel;
    private JLabel secondaryPhoneLabel;
    private JLabel documentLabel;
    private JLabel postalCodeLabel;
    private JLabel docTypeLabel;
    private JLabel passwordLabel;
    private JLabel confirmedPasswordLabel;
    private JLabel emailLabel;
    private JLabel ProvinceLabel;
    private JLabel CountryLabel;
    private JLabel NeighbourhoodLabel;
    private JTextField username;
    private JTextField name;
    private JTextField password;
    private JTextField surname;
    private JTextField country;
    private JTextField address;
    private JTextField email;
    private JTextField postalCode;
    private JTextField neighborhood;
    private JTextField secondaryPhone;
    private JTextField mainPhone;
    private JTextField docType;
    private JTextField confirmedPassword;
    private JTextField document;
    private JTextField province;

    public NewUser(InputController inputController) {
        this.inputController=inputController;
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.getText();
            }
        });
        surname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surname.getText();
            }
        });
        username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.getText();
            }
        });
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password.getText();
            }
        });
        country.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                country.getText();
            }
        });
        address.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                address.getText();
            }
        });
        email.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email.getText();
            }
        });
        province.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                province.getText();
            }
        });
        postalCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postalCode.getText();
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCreationStruct userCreationStruct= new UserCreationStruct(name.getText(),username.getText(),password.getText(),
                        country.getText(), neighborhood.getText(), address.getText(), mainPhone.getText(), surname.getText(),
                        email.getText(), confirmedPassword.getText(), province.getText(), postalCode.getText(), docType.getText(),
                        document.getText(), secondaryPhone.getText());
                System.out.println(inputController);
                if(inputController.checkAll(userCreationStruct)){
                    //mandar a BD y logear
                }else{
                    JOptionPane.showMessageDialog(null, "Input Mistake");
                    //mensajito de error
                }
            }
        });
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public void clearText(){
        name.setText("");
        username.setText("");
        password.setText("");
        country.setText("");
        address.setText("");
        email.setText("");
        postalCode.setText("");
        surname.setText("");

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
