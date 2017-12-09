package View;

import Controller.InputController;
import Controller.UserCreationStruct;
import jdk.internal.util.xml.impl.Input;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
    private boolean isCreating;

    public void setCreating(boolean creating) {
        isCreating = creating;
        if(creating){
            crearButton.setText("Crear");
            crearButton.removeActionListener(modifyListener);
            crearButton.addActionListener(createListener);

        }
        else{
            crearButton.setText("modificar");
            crearButton.removeActionListener(createListener);
            crearButton.addActionListener(modifyListener);
        }
    }

    ActionListener createListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserCreationStruct userCreationStruct= new UserCreationStruct(name.getText(),username.getText(),password.getText(),
                    country.getText(), neighborhood.getText(), address.getText(), mainPhone.getText(), surname.getText(),
                    email.getText(), confirmedPassword.getText(), province.getText(), postalCode.getText(), docType.getText(),
                    document.getText(), secondaryPhone.getText());
            int errorcode=inputController.checkAll(userCreationStruct);
            if(errorcode==0){
                inputController.addUser(userCreationStruct);
                JOptionPane.showMessageDialog(null, "User Created Successfully!");
            }else{
                createUserErrorMessage(errorcode);
            }
        }
    };

    ActionListener modifyListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserCreationStruct userCreationStruct= new UserCreationStruct(name.getText(),username.getText(),password.getText(),
                    country.getText(), neighborhood.getText(), address.getText(), mainPhone.getText(), surname.getText(),
                    email.getText(), confirmedPassword.getText(), province.getText(), postalCode.getText(), docType.getText(),
                    document.getText(), secondaryPhone.getText());
            int errorcode=inputController.checkAll(userCreationStruct);
            if(errorcode==0){
                inputController.addUser(userCreationStruct);
                JOptionPane.showMessageDialog(null, "User Modified Successfully!");
            }else{
                createUserErrorMessage(errorcode);
            }
        }
    };

    public NewUser(final InputController inputController) {
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
                int errorcode=inputController.checkAll(userCreationStruct);
                if(errorcode==0){
                    inputController.addUser(userCreationStruct);
                    JOptionPane.showMessageDialog(null, "User Created Successfully!");
                }else{
                    createUserErrorMessage(errorcode);
                }
            }

        });
    }

    public void createUserErrorMessage(int errorcode) {
        switch (errorcode){
            case 1:
                JOptionPane.showMessageDialog(null, "Nombre incorrecto");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Nombre de Usuario incorrecto");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Pais incorrecto");
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Barrio incorrecto");
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Dirección incorrecta");
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Teléfono incorrecto (debe tener 8 digitos)");
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Apellido incorrecto");
                break;
            case 9:
                JOptionPane.showMessageDialog(null, "E-Mail incorrecto");
                break;
            case 10:
                JOptionPane.showMessageDialog(null, "Provincia incorrecto");
                break;
            case 11:
                JOptionPane.showMessageDialog(null, "Tipo de Documento Incorrecto (debe ser DNI)");
                break;
            case 12:
                JOptionPane.showMessageDialog(null, "Numero de Documento Incorrecto");
                break;
            case 14:
                JOptionPane.showMessageDialog(null, "Numero postal incorrecto");
                break;
            case 15:
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                break;
            default:
                throw new NotImplementedException();
        }
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
        neighborhood.setText("");
        secondaryPhone.setText("");
        mainPhone.setText("");
        docType.setText("");
        confirmedPassword.setText("");
        document.setText("");
        province.setText("");

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
