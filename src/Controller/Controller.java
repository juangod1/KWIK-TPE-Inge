package Controller;

import Model.Model;
import Model.Product;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private DataBaseHandler dBH;
    private Model model;

    //public static void main(String[] args){
      //  Controller controller = new Controller();

        
//    }

    public Controller(){
        dBH = new DataBaseHandler(model);
        dBH.initialize();

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
}
