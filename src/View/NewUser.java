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
    private JTextField username;
    private JTextField name;
    private JPasswordField password;
    private JTextField surname;
    private JTextField country;
    private JTextField address;
    private JTextField phone;
    private JTextField document;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel countryLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel documentLabel;
    private JButton SEARCHbutton;

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
                password.getPassword();
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
        phone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phone.getText();
            }
        });
        document.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                document.getText();
            }
        });
    }

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

}
