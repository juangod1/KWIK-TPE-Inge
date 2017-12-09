package View;

import Controller.Controller;
import Model.Card;
import Model.User;

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
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel CountryLabel;
    private JLabel addressLabel;
    private JLabel postalCodeLabel;
    private JLabel secondaryPhoneLabel;
    private JLabel docTypeLabel;
    private JLabel documentLabel;
    private JButton modificarButton;
    private JLabel NeighbourhoodLabel;
    private JLabel mainPhoneLabel;
    private JLabel ProvinceLabel;
    private JTextArea name;
    private JTextArea surname;
    private JTextArea username;
    private JTextArea email;
    private JTextArea country;
    private JTextArea neighborhood;
    private JTextArea address;
    private JTextArea postalCode;
    private JTextArea mainPhone;
    private JTextArea secondaryPhone;
    private JTextArea docType;
    private JTextArea document;
    private JTextArea province;
    private View.ViewSwapper vs;

    public ProfilePanel(final View.ViewSwapper vs, Controller controller){
        this.vs = vs;

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("newUser",0);
            }
        });
        if(Controller.getInstance().isLoggedIn())
            updateValues();
        
    }

    // TODO: descomentar country provnce doctype y neighborhood por que crashean
    public void updateValues() {
        User currentUser = Controller.getInstance().getCurrentUser();
        username.setText(currentUser.getUsername());
        name.setText(currentUser.getName());
        surname.setText(currentUser.getSurname());
        //country.setText(currentUser.getCountry().getName());
        address.setText(currentUser.getaddress());
        email.setText(currentUser.getEmail());
        postalCode.setText(currentUser.getPostCode());
        //neighborhood.setText(currentUser.getCity().getName());
        secondaryPhone.setText(currentUser.getPhone2());
        mainPhone.setText(currentUser.getPhone());
        //docType.setText(currentUser.getDocType().getName());
        document.setText(currentUser.getdoc());
        //province.setText(currentUser.getProvince().getName());
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
