package View;

import javax.swing.*;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class ProfilePanel {
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
    private JTextField name;
    private JPasswordField password;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel;
    private JButton registrationButton;
    private JLabel newUserLabel;

    public ProfilePanel() {


    }

    public JPasswordField getPassword() {
        return password;
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

    public JButton getRegistrationButton() {
        return registrationButton;
    }


}
