package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cderienzo on 12/7/2017.
 */
public class MainHandler {
    CardLayout cardLayout;
    JPanel cards;
    SearchPanel searchPanel;
    ResultsPanel resultsPanel;
    TeamPanel teamPanel;
    NewUser newUser;
    ProfilePanel profilePanel;
    public MainHandler(){
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        searchPanel = new SearchPanel();
        resultsPanel = new ResultsPanel();
        teamPanel = new TeamPanel();
        newUser = new NewUser();
        profilePanel = new ProfilePanel();
        cards.add(searchPanel.getMainpanel(),"searchPanel");
        cards.add(resultsPanel.getMainpanel(),"resultsPanel");
        cards.add(teamPanel.getMainpanel(),"teamPanel");
        cards.add(newUser.getMainpanel(),"newUser");
        cards.add(profilePanel.getMainpanel(),"profilePanel");
        run();
    }
    public void run(){
        searchPanel.getSearchBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mandar a realizar la busqueda con el input
                String input = searchPanel.getSearchBox().getText();
                cardLayout.show(cards,"resultsPanel");

            }
        });
        profilePanel.getRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"newUser");
            }
        });
        //EQUIPO
        searchPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"teamPanel");
            }
        });
        newUser.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"teamPanel");
            }
        });
        resultsPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"teamPanel");
            }
        });
        teamPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"teamPanel");
            }
        });

        //VISION
        searchPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Vision under development");
            }
        });
        teamPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Vision under development");
            }
        });
        resultsPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Vision under development");
            }
        });
        newUser.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Vision under development");
            }
        });

        //PERFIL
        searchPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"profilePanel");

            }
        });
        teamPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"profilePanel");
            }
        });
        resultsPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"profilePanel");
            }
        });
        newUser.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"profilePanel");
            }
        });

        //MENSAJES
        searchPanel.getMENSAJESbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Messages under development");

            }
        });
        teamPanel.getMENSAJESbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Messages under development");

            }
        });
        resultsPanel.getMENSAJESbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Messages under development");

            }
        });
        newUser.getMENSAJESbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Messages under development");

            }
        });

        //SEARCH
        newUser.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        resultsPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        teamPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        searchPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KWIK");
        frame.setContentPane(new MainHandler().cards);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
