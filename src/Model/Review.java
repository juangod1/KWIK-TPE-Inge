package Model;

public class Review {
    private int ID;
    private Product product;
    private String comment;
    private int rating;

    public Review(int ID, Product product, String comment, int rating) {
        this.ID = ID;
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }
}
