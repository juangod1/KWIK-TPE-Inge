package View;

import javax.swing.*;

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
