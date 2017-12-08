package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class NewUser {
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
    private JTextField Province;
    private JTextField neighborhood;
    private JTextField secondaryPhone;
    private JTextField mainPhone;
    private JTextField docType;
    private JTextField confirmedPassword;
    private JTextField document;

    public NewUser() {
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
        postalCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postalCode.getText();
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
