package Model;

import java.util.ArrayList;

public class Model {
    private ArrayList<Cart> carts;
    private ArrayList<Card> cards;
    private ArrayList<Product> products;
    private User user;

    public User getUser(){
        return user;
    }

    public Model(){
        carts = new ArrayList<>();
        cards = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void deleteProduct(Product prod){
        products.remove(prod);
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

}
