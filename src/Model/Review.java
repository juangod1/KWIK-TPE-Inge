package Model;

public class Review {
    private int id;
    private Product product;
    private String comment;
    private int rating;

    public Review(int id, Product product, String comment, int rating) {
        this.id = id;
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }
}
