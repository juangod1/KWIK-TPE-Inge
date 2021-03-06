package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class ProfileLoginPanel {
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
    private JButton loginButton;
    private View.ViewSwapper vs;


    public ProfileLoginPanel(final View.ViewSwapper vs) {

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("user: "+ name.getText()+" pw: "+password.getText());
                if(!Controller.getInstance().isLoggedIn()) {
                    if (Controller.getInstance().logInUser(name.getText(), password.getText())) {
                        Controller.getView().setViewsAsLoggedIn();
                        vs.changeView("searchPanel", null);
                    } else {
                        JOptionPane.showMessageDialog(null, "invalid username or password");

                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "ya esta logeado, esto no deberia pasar");
                }
            }
        });
        this.vs = vs;

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("newUser", 1);
            }
        });
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] ps =  password.getPassword();
                System.out.println(ps);
                //Si se loggeo deberia setear loggedin en true
                //loggedIn=true;
            }
        });
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
