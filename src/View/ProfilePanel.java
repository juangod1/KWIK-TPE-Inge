package View;

import Controller.Controller;
import Model.Card;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel registrationLabel;
    private JTextField surname;
    private JTextField name;
    private JTextField username;
    private JTextField neighborhood;
    private JTextField country;
    private JTextField postalCode;
    private JTextField address;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel CountryLabel;
    private JLabel addressLabel;
    private JLabel postalCodeLabel;
    private JTextField mainPhone;
    private JLabel secondaryPhoneLabel;
    private JTextField secondaryPhone;
    private JLabel docTypeLabel;
    private JLabel passwordLabel;
    private JTextField password;
    private JTextField document;
    private JTextField confirmedPassword;
    private JLabel documentLabel;
    private JLabel confirmedPasswordLabel;
    private JButton modificarButton;
    private JLabel NeighbourhoodLabel;
    private JLabel mainPhoneLabel;
    private JLabel ProvinceLabel;
    private JTextField email;
    private JTextField province;
    private JTextField docType;
    private View.ViewSwapper vs;

    public ProfilePanel(final View.ViewSwapper vs, Controller controller){
        this.vs = vs;

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("newUser",1);
            }
        });
        
    }

    public JButton getVISIONButton() {
        return VISIONButton;
    }

    public JButton getCARRITObutton() {
        return CARRITObutton;
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public JButton getEQUIPObutton() {
        return EQUIPObutton;
    }

    public JButton getSEARCHbutton() {
        return SEARCHbutton;
    }

    public JButton getPERFILButton() {
        return PERFILButton;
    }


}
