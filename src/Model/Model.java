package Model;

import java.util.ArrayList;

public class Model {
    private ArrayList<Cart> carts;
    private ArrayList<Card> cards;
    private ArrayList<Product> products;
    private User user;

    public Model(){
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
}
