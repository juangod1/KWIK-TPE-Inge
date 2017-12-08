package Model;

import java.util.HashMap;

public class Cart {
    private HashMap<Product,Integer> products;
    private int id;
    private User user;
    private boolean closed;
    private double subTotal;
    private Card card;

    public Cart(int id, User user){
        closed = false;
        card = null;
        this.user = user;
        this.id = id;
        subTotal = 0.0;
    }

    public boolean addProduct(Product product){
        if(closed)
            return false;

        subTotal += product.getPrice();

        if(products.containsKey(product)){
            products.put(product,products.get(product)+1);
        }

        products.put(product,1);
        return true;
    }

    public boolean removeProduct(Product product){
        if(closed)
            return false;

        if(products.containsKey(product)){
            products.remove(product);
            subTotal -= product.getPrice();
            return true;
        }
        return false;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void close(){
        closed = true;
    }
}
