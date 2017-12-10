package Controller;

import Model.*;
import Model.Product;
import Service.DatabaseService;
import Model.Card;
import View.*;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private static Controller singleton;
    private DataBaseHandler dBH;
    private InputController inputController;
    private  Model model;
    private static View view;

    public static View getView(){
        return view;
    }

    public static void main(String[] args){
        view = new View(getInstance());
        view.initialize(getInstance());
        DatabaseService.getInstance().initializeDB();
        User user = User.login("admin", "admin");
        System.out.println("User: " + (user != null));
    }
    public static Controller getInstance(){
        if(singleton==null){
            singleton=new Controller();
        }
        return singleton;
    }

    private Controller(){
        dBH = new DataBaseHandler(model);
        dBH.initialize();
        inputController= new InputController(this);
        model = new Model();
    }

    public ArrayList<Product> productSearch(String search){
        /*ArrayList<Product> list = new ArrayList<>();

        search = search.toLowerCase();

        String[] words = search.split(" ");

        for(Product prod : model.getProducts()){
            String prodName = prod.getName().toLowerCase();

            for(String word : words){
                if(word.equals(prodName))
                    list.add(prod);
            }
        }

        Collections.shuffle(list);

        return list;
        */
        return null;
    }

    public InputController getInputController() {
        return inputController;
    }


    public  Model getModel(){
        return model;
    }

    public  boolean isLoggedIn(){
        if(model.getUser() != null) {
            System.out.println("logged as: " + model.getUser().getName());
            return true;
        }
        return false;
    }

    public  boolean logInUser(String username, String password){
        User user = User.login(username, password);
        if(user !=null && user.isEnabled()){
            model.setUser(user);
            view.setViewsAsLoggedIn();
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        return model.getUser();
    }

    public  void setUser(User user) {
        getModel().replaceUser(user);
    }

}
