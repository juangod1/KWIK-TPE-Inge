package Model;

import java.util.ArrayList;

public class Product implements Persistent{
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private User user;
    private String thumbnail;
    private int visits;
    private int sold;

    private Product() {}

    private Product(int id, String name, String description, double price, User user, String thumbnail, int stock){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = user;
        this.thumbnail = thumbnail;
        this.stock = stock;

        visits=0;
        sold=0;
    }

    public static Product create(String name, String description, double price, User user, String thumbnail, int stock) {
        return new Product();
    }

    public static Product get(int id) {
        return new Product();
    }

    public static ArrayList<Product> list() {
        return new ArrayList<>();
    }

    public static ArrayList<Product> list(User user) {
        return new ArrayList<>();
    }

    public static ArrayList<Product> search(String text) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public ArrayList<Review> getReviews() {
        return new ArrayList<>();
    }

    public ArrayList<Picture> getPictures() {
        return new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return 17*id;
    }
}
