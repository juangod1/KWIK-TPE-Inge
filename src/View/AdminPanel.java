package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class AdminPanel {
    private final Controller controller;
    private JPanel mainpanel;
    private JPanel header;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JLabel KWIKlabel;
    private JButton CARRITObutton;
    private JPanel footnote;
    private JButton SEARCHbutton;
    private JPanel middle;
    private JLabel resultsLabel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton desactivarButton;
    private JButton desactivarButton1;
    private JButton desactivarButton2;
    private JButton desactivarButton3;
    private JButton desactivarButton4;
    private JButton searchButton;
    private JTextField textField1;
    private ArrayList<JButton> buttons;
    private ArrayList<JTextArea> textAreas;
    private Iterator<User> userIterator;

    public void printUsers(String criteria){
        clearItems();
        if(userIterator==null) {
            User user = controller.getCurrentUser();
            if(user!=null && user.isAdmin()) {
                ArrayList<User> list=User.search(criteria);
                System.out.println(list.isEmpty());
                userIterator=(!list.isEmpty())?list.iterator():null;
            }
        }
        if(userIterator!=null) {
            Iterator<JButton> buttonIterator = buttons.iterator();
            Iterator<JTextArea> jTextAreaIterator = textAreas.iterator();
            for (int i = 0; i < 5 && userIterator.hasNext(); i++) {
                User curr = userIterator.next();
                JButton currButton = buttonIterator.next();
                jTextAreaIterator.next().setText(curr.getUsername() + "    -    " + curr.getEmail() + "    -    " + curr.getName()+
                curr.getSurname());
                if(curr.isEnabled()){currButton.setText("Desactivar");
                }else{currButton.setText("Activar");}
                currButton.setVisible(true);

                currButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        curr.setEnabled(!curr.isEnabled());
                        if(curr.isEnabled()){
                            currButton.setText("Desactivar");
                            JOptionPane.showMessageDialog(null, "Usuario Activado!");
                        }else{
                            currButton.setText("Activar");
                            JOptionPane.showMessageDialog(null, "Usuario Desactivado!");
                        }
                        curr.save();
                    }
                });
            }
            if (!userIterator.hasNext()) {
                userIterator = null;
            }
        }
    }

    public AdminPanel(Controller controller){
        this.controller=controller;
        buttons=new ArrayList<>();
        buttons.add(desactivarButton);buttons.add(desactivarButton1);buttons.add(desactivarButton2);buttons.add(desactivarButton3);
        buttons.add(desactivarButton4);
        textAreas= new ArrayList<>();
        textAreas.add(textArea1);textAreas.add(textArea2);textAreas.add(textArea3);textAreas.add(textArea4);textAreas.add(textArea5);
        userIterator=null;
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userIterator=null;
                printUsers(textField1.getText());
            }
        });
    }

    private void clearItems(){
        Iterator<JButton> buttonIterator = buttons.iterator();
        JButton curr;
        for (JTextArea jTextArea: textAreas){
            jTextArea.setText("");
            curr = buttonIterator.next();
            curr.setVisible(false);
            if(curr.getActionListeners().length!=0)
            curr.removeActionListener(curr.getActionListeners()[0]);
        }
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
