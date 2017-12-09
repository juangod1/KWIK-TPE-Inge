package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cderienzo on 12/9/2017.
 */
public class ProfileMenuPanel {
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
    private JButton agregarProductoButton;
    private JButton verDatosButton;
    private View.ViewSwapper vs;
    public ProfileMenuPanel(final View.ViewSwapper vs) {
        this.vs= vs;
        verDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("profilePanel",null);
            }
        });
        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vs.changeView("addProductPanel",null);
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
