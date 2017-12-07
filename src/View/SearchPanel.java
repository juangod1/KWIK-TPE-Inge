package View;

import javax.swing.*;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class SearchPanel {
    private JPanel mainpanel;
    private JLabel KWIKlabel;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JButton CARRITObutton;
    private JPanel footnote;
    private JPanel header;
    private JTextField searchBox;
    private JPanel middle;
    private JLabel searchLabel;
    private JButton SEARCHbutton;

    public SearchPanel() {

    }

    public JButton getVISIONButton() {
        return VISIONButton;
    }

    public JButton getPERFILButton() {
        return PERFILButton;
    }

    public JButton getCARRITObutton() {
        return CARRITObutton;
    }

    public JTextField getSearchBox() {
        return searchBox;
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

}
