package Model;

public class Product {
    private int id;
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
    private String category;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public User getUser() {
        return user;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getVisits() {
        return visits;
    }

    public int getSold() {
        return sold;
    }

    public Review getReview() {
        return review;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getCategory() {
        return category;
    }

    public Product(int id, String name, String description, double price, User user, String thumbnail, int stock){
        this.id = id;
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
        return 17*id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
