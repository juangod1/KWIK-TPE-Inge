package Controller;

import Model.Model;
import Model.Product;
import View.*;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private static Controller singleton;
    private DataBaseHandler dBH;
    private InputController inputController;
    private Model model;
    private View view;

    public static void main(String[] args){
        View view = new View(getInstance());
        view.initialize(getInstance());
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
        ArrayList<Product> list = new ArrayList<>();

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
    }

    public InputController getInputController() {
        return inputController;
    }
}
