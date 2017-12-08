package Model;

import java.util.ArrayList;

public class Picture implements Persistent{
    private int id;
    private Product product;
    private String path;

    private Picture() {}

    private Picture(int id, Product product, String path) {
        this.id = id;
        this.product = product;
        this.path = path;
    }

    public static Picture create(Product product, String path) {
        return new Picture();
    }

    public static Picture get(int id) {
        return new Picture();
    }

    public static ArrayList<Picture> list(Product product) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
