package View;

import Controller.Controller;
import Model.Cart;
import Model.Product;

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
    AdminPanel adminPanel;
    NewUser newUser;
    PaymentOptionsPanel paymentOptions;
    ProfileLoginPanel profileLoginPanel;
    ProfilePanel profilePanel;
    ShoppingcartPanel shoppingcartPanel;
    MisProductosPanel misProductosPanel;
    AddProductPanel addProductPanel;
    ViewProduct viewProduct;
    ReviewsPanel reviewsPanel;
    ProfileMenuPanel profileMenuPanel;
    ComprasPanel comprasPanel;
    static RateProduct rateProduct;
    boolean loggedIn;
    ViewSwapper viewSwapper = new ViewSwapper();
    CartSwapper cartSwapper = new CartSwapper();
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

    public class CartSwapper{
        public void swapCard(Cart cart){
            paymentOptions.setCart(cart);
        }
    }

    public View(Controller controller){

        this.controller=controller;
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        searchPanel = new SearchPanel();
        resultsPanel = new ResultsPanel(controller);
        adminPanel = new AdminPanel(controller);
        reviewsPanel = new ReviewsPanel();
        newUser = new NewUser(controller.getInputController());
        paymentOptions = new PaymentOptionsPanel(viewSwapper, controller.getInputController());
        shoppingcartPanel = new ShoppingcartPanel(viewSwapper, controller, cartSwapper);
        profileLoginPanel = new ProfileLoginPanel(viewSwapper);
        profilePanel = new ProfilePanel(viewSwapper, controller);
        misProductosPanel = new MisProductosPanel(controller, this);
        viewProduct = new ViewProduct();
        addProductPanel = new AddProductPanel(viewSwapper, controller.getInputController());
        profileMenuPanel = new ProfileMenuPanel(viewSwapper, controller);
        comprasPanel = new ComprasPanel(viewSwapper,controller);
        rateProduct = new RateProduct(viewSwapper);
        cards.add(searchPanel.getMainpanel(),"searchPanel");
        cards.add(resultsPanel.getMainpanel(),"resultsPanel");
        cards.add(adminPanel.getMainpanel(),"adminPanel");
        cards.add(newUser.getMainpanel(),"newUser");
        cards.add(paymentOptions.getMainpanel(),"paymentOptionsPanel");
        cards.add(profileLoginPanel.getMainpanel(),"profileLoginPanel");
        cards.add(profilePanel.getMainpanel(), "profilePanel");
        cards.add(shoppingcartPanel.getMainpanel(),"shoppingcartPanel");
        cards.add(misProductosPanel.getMainpanel(),"misProductosPanel");
        cards.add(viewProduct.getMainpanel(),"viewProductPanel");
        cards.add(reviewsPanel.getMainpanel(),"reviewsPanel");
        cards.add(addProductPanel.getMainpanel(),"addProductPanel");
        cards.add(profileMenuPanel.getMainpanel(),"profileMenuPanel");
        cards.add(comprasPanel.getMainpanel(),"comprasPanel");
        cards.add(rateProduct.getMainpanel(),"rateProductPanel");
        loggedIn = false;
        run();
    }

    public void run(){
        configureSearchView();

        configureEquipoButtons();

        configurePerfilButtons();

        configureCarritoButtons();

        configureSearchButtons();

        configureVisionButtons();
    }


    public void initialize(Controller controller) {
        JFrame frame = new JFrame("KWIK");
        frame.setContentPane(this.cards);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Dimension dimension = new Dimension(1067,600);
        frame.setMinimumSize(dimension);
        frame.setPreferredSize(dimension);
        frame.setMaximumSize(dimension);
    }

    public void setViewsAsLoggedIn(){
        profilePanel.updateValues();
        comprasPanel.setLoggedInConfigurations();
    }

    public void configureSearchButtons(){
        //SEARCH
        comprasPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        rateProduct.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        reviewsPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
        addProductPanel.getSEARCHbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"searchPanel");
            }
        });
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
        adminPanel.getSEARCHbutton().addActionListener(new ActionListener() {
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
        misProductosPanel.getSEARCHbutton().addActionListener(new ActionListener() {
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

    public void configureCarritoButtons(){
        //CARRITO
        comprasPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }
            }
        });

        rateProduct.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }
            }
        });
        reviewsPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }
            }
        });
        addProductPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }
            }
        });
        searchPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Messages under development");
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }
            }
        });
        adminPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        resultsPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        newUser.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        profileLoginPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        shoppingcartPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        misProductosPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        viewProduct.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        profilePanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
        profileMenuPanel.getCARRITObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"shoppingcartPanel");
                if(Controller.getInstance().isLoggedIn()) {
                    paymentOptions.setCards();
                }            }
        });
    }

    public void configurePerfilButtons(){
        //PERFIL

        comprasPanel.getPERFILbutton().addActionListener(new ActionListener() {
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
        rateProduct.getPERFILButton().addActionListener(new ActionListener() {
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
        reviewsPanel.getPERFILButton().addActionListener(new ActionListener() {
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
        addProductPanel.getPERFILButton().addActionListener(new ActionListener() {
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
        adminPanel.getPERFILButton().addActionListener(new ActionListener() {
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
        misProductosPanel.getPERFILButton().addActionListener(new ActionListener() {
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
    }

    public void setAdminButtonVisible(boolean visible) {
        Color color;
        if(visible)
            color = Color.white;
        else
            color = new Color(130, 232, 94);

        comprasPanel.getEQUIPObutton().setForeground(color);
        rateProduct.getEQUIPObutton().setForeground(color);
        addProductPanel.getEQUIPObutton().setForeground(color);
        reviewsPanel.getEQUIPObutton().setForeground(color);
        searchPanel.getEQUIPObutton().setForeground(color);
        newUser.getEQUIPObutton().setForeground(color);
        resultsPanel.getEQUIPObutton().setForeground(color);
        adminPanel.getEQUIPObutton().setForeground(color);
        profileLoginPanel.getEQUIPObutton().setForeground(color);
        shoppingcartPanel.getEQUIPObutton().setForeground(color);
        misProductosPanel.getEQUIPObutton().setForeground(color);
        viewProduct.getEQUIPObutton().setForeground(color);
        profilePanel.getEQUIPObutton().setForeground(color);
        profileMenuPanel.getEQUIPObutton().setForeground(color);
    }

    public void configureEquipoButtons(){
        //EQUIPO

        setAdminButtonVisible(false);

        comprasPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanel.printUsers("");
                cardLayout.show(cards,"adminPanel");
            }
        });
        rateProduct.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanel.printUsers("");
                cardLayout.show(cards,"adminPanel");
            }
        });
        addProductPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanel.printUsers("");
                cardLayout.show(cards,"adminPanel");
            }
        });
        reviewsPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanel.printUsers("");
                cardLayout.show(cards,"adminPanel");
            }
        });
        searchPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        newUser.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        resultsPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        adminPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        profileLoginPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        shoppingcartPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        misProductosPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        viewProduct.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });

        profilePanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
        profileMenuPanel.getEQUIPObutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminPanel.printUsers("")) {
                    cardLayout.show(cards, "adminPanel");
                }
            }
        });
    }

    public void configureVisionButtons(){
        //VISION
        comprasPanel.getVISIONbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"misProductosPanel");
                misProductosPanel.printItems();
            }
        });
        rateProduct.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"misProductosPanel");
                misProductosPanel.printItems();
            }
        });
        addProductPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"misProductosPanel");
                misProductosPanel.printItems();
            }
        });
        searchPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards,"misProductosPanel");
                misProductosPanel.printItems();
            }
        });
        adminPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        resultsPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        newUser.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        profileLoginPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        shoppingcartPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        misProductosPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        viewProduct.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        profilePanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        profileMenuPanel.getVISIONButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
            }
        });
        reviewsPanel.getMISPRODUCTOSButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                misProductosPanel.printItems();
                cardLayout.show(cards,"misProductosPanel");
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
                if(viewProduct.getREVIEWSButton().getActionListeners().length > 0)
                    viewProduct.getREVIEWSButton().removeActionListener(viewProduct.getREVIEWSButton().getActionListeners()[0]);
                viewProduct.getREVIEWSButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cards,"reviewsPanel");
                    }
                });

            }
        });
    }

    public void updateViewProductButtons(final ArrayList<Product> products){

        if(resultsPanel.getViewButton().getActionListeners().length > 0)
            resultsPanel.getViewButton().removeActionListener(resultsPanel.getViewButton().getActionListeners()[0]);

        resultsPanel.getViewButton().addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                if(products.size()>=1) {
                    Product prod = products.get(0);
                    prod.incrementVisits();
                    viewProduct.printProduct(prod);
                    cardLayout.show(cards,"viewProductPanel");
                    reviewsPanel.setProduct(prod);
                }

            }

        });

        if(resultsPanel.getViewButton1().getActionListeners().length > 0)
            resultsPanel.getViewButton1().removeActionListener(resultsPanel.getViewButton1().getActionListeners()[0]);

        resultsPanel.getViewButton1().addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                if(products.size()>=2) {
                    Product prod = products.get(1);
                    prod.incrementVisits();
                    viewProduct.printProduct(prod);
                    cardLayout.show(cards,"viewProductPanel");
                    reviewsPanel.setProduct(prod);
                }

            }

        });

        if(resultsPanel.getViewButton2().getActionListeners().length > 0)
            resultsPanel.getViewButton2().removeActionListener(resultsPanel.getViewButton2().getActionListeners()[0]);

        resultsPanel.getViewButton2().addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                if(products.size()>=3) {
                    Product prod = products.get(2);
                    prod.incrementVisits();
                    viewProduct.printProduct(prod);
                    cardLayout.show(cards,"viewProductPanel");
                    reviewsPanel.setProduct(prod);
                }

            }

        });

        if(resultsPanel.getViewButton3().getActionListeners().length > 0)
            resultsPanel.getViewButton3().removeActionListener(resultsPanel.getViewButton3().getActionListeners()[0]);

        resultsPanel.getViewButton3().addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                if(products.size()>=4) {
                    Product prod = products.get(3);
                    prod.incrementVisits();
                    viewProduct.printProduct(prod);
                    cardLayout.show(cards,"viewProductPanel");
                    reviewsPanel.setProduct(prod);
                }

            }

        });

        if(resultsPanel.getViewButton4().getActionListeners().length > 0)
            resultsPanel.getViewButton4().removeActionListener(resultsPanel.getViewButton4().getActionListeners()[0]);

        resultsPanel.getViewButton4().addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                if(products.size()>=5) {
                    Product prod = products.get(4);
                    prod.incrementVisits();
                    viewProduct.printProduct(prod);
                    cardLayout.show(cards,"viewProductPanel");
                    reviewsPanel.setProduct(prod);
                }

            }

        });

    }

    public static RateProduct getRateProduct() {
        return rateProduct;
    }

}


