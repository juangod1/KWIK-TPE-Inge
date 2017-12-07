package Model;

public class Picture {
    private int ID;
    private Product product;
    private String path;

    public Picture(int ID, Product product, String path) {
        this.ID = ID;
        this.product = product;
        this.path = path;
    }
}
