package Model;

import java.util.ArrayList;

public class Cart implements Persistent {
    private int id;
    private User user;
    private boolean closed;
    private double subTotal;
    private Card card;

    private Cart() {}

    private Cart(int id, User user, boolean closed, double subTotal, Card card){
        this.closed = false;
        this.card = null;
        this.user = user;
        this.id = id;
        this.subTotal = 0.0;
    }

    public static Cart create(User user) {
        return new Cart(0, user, false, 0, null);
    }

    public static Cart get(int id) {
        return new Cart();
    }

    public static Cart getUserCart(User user) {
        return new Cart();
    }

    public static ArrayList<Cart> closedCarts(User user) {
        return new ArrayList<>();
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isClosed() {
        return closed;
    }

    public void close(){
        closed = true;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        return false;
    }

    public boolean removeProduct(Product product) {
        return false;
    }
}
