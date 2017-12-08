package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
    ShoppingcartPanel shoppingcartPanel;
    boolean loggedIn;
    public MainHandler(){
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        searchPanel = new SearchPanel();
        resultsPanel = new ResultsPanel();
        teamPanel = new TeamPanel();
        newUser = new NewUser();
        shoppingcartPanel = new ShoppingcartPanel();
        profilePanel = new ProfilePanel();
        cards.add(searchPanel.getMainpanel(),"searchPanel");
        cards.add(resultsPanel.getMainpanel(),"resultsPanel");
        cards.add(teamPanel.getMainpanel(),"teamPanel");
        cards.add(newUser.getMainpanel(),"newUser");
        cards.add(profilePanel.getMainpanel(),"profilePanel");
        cards.add(shoppingcartPanel.getMainpanel(),"shoppingcartPanel");
        loggedIn = false;
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
        profilePanel.getPassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] ps =  profilePanel.getPassword().getPassword();
                System.out.println(ps);
                //Si se loggeo deberia setear loggedin en true
                loggedIn=true;
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
        profilePanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"teamPanel");
            }
        });
        shoppingcartPanel.getEQUIPObutton().addActionListener(new ActionListener() {
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
        profilePanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Vision under development");
            }
        });
        shoppingcartPanel.getVISIONButton().addActionListener(new ActionListener() {
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
        profilePanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"profilePanel");


            }
        });
        shoppingcartPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"profilePanel");
            }
        });



        //CARRITO
        searchPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Messages under development");
                cardLayout.show(cards,"shoppingcartPanel");

            }
        });
        teamPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
            }
        });
        resultsPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
            }
        });
        newUser.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");

            }
        });
        profilePanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");

            }
        });
        shoppingcartPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");

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
        profilePanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        shoppingcartPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
    }

    public static void initialize() {
        JFrame frame = new JFrame("KWIK");
        frame.setContentPane(new MainHandler().cards);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
