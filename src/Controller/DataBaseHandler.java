package Controller;

import Model.Card;
import Model.Cart;
import Model.Product;
import Model.User;

import java.util.ArrayList;

public class DataBaseHandler {
    private String url;
    private User user;
    private ArrayList<Cart> carts;
    private ArrayList<Card> cards;
    private ArrayList<Product> products;

    public DataBaseHandler(){
        carts = new ArrayList<>();
        cards = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void createProduct(int ID, String name, String description, double price, User user, String thumbnail, int stock){
        Product newprod = new Product(ID, name, description, price, user, thumbnail, stock);
        products.add(newprod);
    }

    public void deleteProduct(Product prod){
        products.remove(prod);
    }

    public void updateProduct(){

    }

    public void updateUser(){

    }

    public void updateCart(){

    }

    public void updateCard(){

    }
}
