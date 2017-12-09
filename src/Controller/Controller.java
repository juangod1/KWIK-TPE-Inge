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
    private static Model model;
    private View view;

    public static void main(String[] args){
        View view = new View(getInstance());
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
        inputController= new InputController();
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


    public Model getModel(){
        return model;
    }

    public boolean isLoggedIn(){
        if(model.getUser() != null)
            return true;
        return false;
    }

    public static boolean setUser(User user){
        return model.setUser(user);
    }
}
