package Model;

import java.util.ArrayList;

public class Review implements Persistent{
    private int id;
    private Product product;
    private String comment;
    private int rating;

    private Review() {}

    private Review(int id, Product product, String comment, int rating) {
        this.id = id;
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }

    public static Review create(Product product, String comment, int rating) {
        return new Review();
    }

    public static Review get(int id) {
        return new Review();
    }

    public static ArrayList<Review> list(Product product) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
