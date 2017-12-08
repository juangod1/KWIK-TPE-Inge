package Model;

public class Picture {
    private int id;
    private Product product;
    private String path;

    public Picture(int id, Product product, String path) {
        this.id = id;
        this.product = product;
        this.path = path;
    }
}
