package View;

import Controller.Controller;
import Model.Cart;
import Model.Product;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by cderienzo on 12/7/2017.
 */

public class View {
     CardLayout cardLayout;
     JPanel cards;
    SearchPanel searchPanel;
    ResultsPanel resultsPanel;
    TeamPanel teamPanel;
    NewUser newUser;
    PaymentOptionsPanel paymentOptions;
    ProfileLoginPanel profileLoginPanel;
    ProfilePanel profilePanel;
    ShoppingcartPanel shoppingcartPanel;
    VisionPanel visionPanel;
    AddProductPanel addProductPanel;
    ViewProduct viewProduct;
    ProfileMenuPanel profileMenuPanel;
    boolean loggedIn;
    ViewSwapper viewSwapper = new ViewSwapper();
    Controller controller;


    // TODO: hacer que si loggedIn true el boton de profile llame a profilePanel y no a ProfileLoginPanel
    public  class ViewSwapper {
        public void changeView(String name,Integer options) {
            cardLayout.show(cards, name);
            if(name == "newUser"){
                newUser.clearText();
                if(options == 0){
                    newUser.setCreating(false);
                }
                else{
                    newUser.setCreating(true);
                }
            }
        }
    }

    public View(Controller controller){

        this.controller=controller;
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        searchPanel = new SearchPanel();
        resultsPanel = new ResultsPanel(controller);
        teamPanel = new TeamPanel();
        newUser = new NewUser(controller.getInputController());
        paymentOptions = new PaymentOptionsPanel(viewSwapper, controller.getInputController());
        shoppingcartPanel = new ShoppingcartPanel(viewSwapper, controller);
        profileLoginPanel = new ProfileLoginPanel(viewSwapper);
        profilePanel = new ProfilePanel(viewSwapper, controller);
        visionPanel = new VisionPanel();
        viewProduct = new ViewProduct();
        addProductPanel = new AddProductPanel(viewSwapper);
        profileMenuPanel = new ProfileMenuPanel(viewSwapper);
        cards.add(searchPanel.getMainpanel(),"searchPanel");
        cards.add(resultsPanel.getMainpanel(),"resultsPanel");
        cards.add(teamPanel.getMainpanel(),"teamPanel");
        cards.add(newUser.getMainpanel(),"newUser");
        cards.add(paymentOptions.getMainpanel(),"paymentOptionsPanel");
        cards.add(profileLoginPanel.getMainpanel(),"profileLoginPanel");
        cards.add(profilePanel.getMainpanel(), "profilePanel");
        cards.add(shoppingcartPanel.getMainpanel(),"shoppingcartPanel");
        cards.add(visionPanel.getMainpanel(),"visionPanel");
        cards.add(viewProduct.getMainpanel(),"viewProductPanel");
        cards.add(addProductPanel.getMainpanel(),"addProductPanel");
        cards.add(profileMenuPanel.getMainpanel(),"profileMenuPanel");
        loggedIn = false;
        run();
    }

    public void run(){
        configureSearchView();


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
        profileLoginPanel.getEQUIPObutton().addActionListener(new ActionListener() {
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
        visionPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"teamPanel");
            }
        });
        viewProduct.getEQUIPObutton().addActionListener(new ActionListener() {
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
        profileMenuPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"teamPanel");
            }
        });

        //VISION
        searchPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        teamPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        resultsPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        newUser.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        profileLoginPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        shoppingcartPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        visionPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        viewProduct.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        profilePanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });
        profileMenuPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"visionPanel");
            }
        });


        //PERFIL
        searchPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    profilePanel.updateValues();
                    cardLayout.show(cards, "profileMenuPanel");
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        teamPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                    profilePanel.updateValues();
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        resultsPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                    profilePanel.updateValues();
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        newUser.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                    profilePanel.updateValues();
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        profileLoginPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                    profilePanel.updateValues();
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        shoppingcartPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                    profilePanel.updateValues();
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        visionPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                    profilePanel.updateValues();
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        paymentOptions.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    profilePanel.updateValues();
                    cardLayout.show(cards, "profileMenuPanel");
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        profilePanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    profilePanel.updateValues();
                    cardLayout.show(cards, "profileMenuPanel");
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        viewProduct.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
            }
        });
        profileMenuPanel.getPERFILButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getInstance().isLoggedIn()) {
                    cardLayout.show(cards, "profileMenuPanel");
                }
                else{
                    cardLayout.show(cards, "profileLoginPanel");
                }
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
        profileLoginPanel.getCARRITObutton().addActionListener(new ActionListener() {
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
        visionPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
            }
        });
        viewProduct.getCARRITObutton().addActionListener(new ActionListener() {
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
        profileMenuPanel.getCARRITObutton().addActionListener(new ActionListener() {
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
        profileLoginPanel.getSEARCHbutton().addActionListener(new ActionListener() {
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
        visionPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        viewProduct.getSEARCHbutton().addActionListener(new ActionListener() {
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
        profileMenuPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });


    }

    public void configureSearchView(){
        searchPanel.getSearchBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mandar a realizar la busqueda con el input
                String input = searchPanel.getSearchBox().getText();
                final ArrayList<Product> prods = Product.search(input);

                cardLayout.show(cards,"resultsPanel");

                resultsPanel.printResults(prods);
                searchPanel.getSearchBox().setText("");



                //config de view product
                resultsPanel.getViewButton().addActionListener(new ActionListener() {

                    @Override

                    public void actionPerformed(ActionEvent e) {

                        if(prods.size()>=1) {
                            viewProduct.printProduct(prods.get(0));
                            cardLayout.show(cards,"viewProductPanel");
                        }

                    }

                });
                resultsPanel.getViewButton1().addActionListener(new ActionListener() {

                    @Override

                    public void actionPerformed(ActionEvent e) {
                        if(prods.size()>=2) {
                            viewProduct.printProduct(prods.get(1));
                            cardLayout.show(cards,"viewProductPanel");
                        }

                    }

                });
                resultsPanel.getViewButton2().addActionListener(new ActionListener() {

                    @Override

                    public void actionPerformed(ActionEvent e) {
                        if(prods.size()>=3) {
                            viewProduct.printProduct(prods.get(2));
                            cardLayout.show(cards,"viewProductPanel");
                        }

                    }

                });
                resultsPanel.getViewButton3().addActionListener(new ActionListener() {

                    @Override

                    public void actionPerformed(ActionEvent e) {
                        if(prods.size()>=4) {
                            viewProduct.printProduct(prods.get(3));
                            cardLayout.show(cards,"viewProductPanel");
                        }

                    }

                });
                resultsPanel.getViewButton4().addActionListener(new ActionListener() {

                    @Override

                    public void actionPerformed(ActionEvent e) {
                        if(prods.size()>=5) {
                            viewProduct.printProduct(prods.get(4));
                            cardLayout.show(cards,"viewProductPanel");
                        }

                    }

                });

            }
        });
    }

    public void initialize(Controller controller) {
        JFrame frame = new JFrame("KWIK");
        frame.setContentPane(new View(controller).cards);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.controller = controller;
    }

    public void setViewsAsLoggedIn(){
        profilePanel.updateValues();
    }

}
