package Model;

public class Product {
    private int ID;
    private String name;
    private String description;
    private double price;
    private int stock;
    private User user;
    private String thumbnail;
    private int visits;
    private int sold;
    private Review review;
    private Picture picture;

    public Product(int ID, String name, String description, double price, User user, String thumbnail, int stock){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = user;
        this.thumbnail = thumbnail;
        this.stock = stock;

        visits=0;
        sold=0;
        review = null;//instanciar
        picture = null;//instanciar
    }

    @Override
    public int hashCode() {
        return 17*ID;
    }

    public String getName() {
        return name;
    }
}
