package Model;

import Service.DatabaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

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

    private int userId;

    private Product() {}

    private Product(int id, String name, String description, double price, User user, String thumbnail, int stock){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = user;
        this.thumbnail = thumbnail;
        this.stock = stock;
        this.visits=0;
        this.sold=0;
    }

    private Product(int id, String name, String description, double price, int userId, String thumbnail, int stock, int visits, int sold) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.user = null;
        this.thumbnail = thumbnail;
        this.stock = stock;
        this.visits = visits;
        this.sold = sold;
    }

    private static final String select = "SELECT * FROM product ";
    private static final String update = "UPDATE product SET name = '%s', description = '%s', price = %f, idclient = %d, thumbnail = '%s', " +
            "stock = %d, visits = %d, sold = %d WHERE id = %d";

    public static Product create(String name, String description, double price, User user, String thumbnail, int stock) {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery("INSERT INTO product (name, description, price, stock, idclient, thumbnail) " +
                    "VALUES ('"+name+"', '"+description+"', "+price+", "+stock+", "+user.getId()+", "+(thumbnail==null?"NULL":"'"+thumbnail+"'")+") " +
                    "RETURNING id");
            if(rs.next())
                return new Product(rs.getInt(1), name, description, price, user, thumbnail, stock);
            else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Product get(int id) {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select+"WHERE id = "+id);
            if(rs.next())
                return fromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Product> listByCriteria(String criteria) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select + criteria);
            while (rs.next()) {
                products.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static ArrayList<Product> getByUser(User user) {
        return listByCriteria("WHERE idclient = "+user.getId());
    }

    public static ArrayList<Product> list() {
        return listByCriteria("");
    }

    public static ArrayList<Product> search(String text) {
        return listByCriteria("WHERE stock > 0 AND name ILIKE '%"+text+"%'");
    }

    public static HashMap<Product, Integer> listBoughtProducts(User user) {
        HashMap<Product, Integer> products = new HashMap<>();
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery("SELECT p.*, cp.id as idcp FROM cart c " +
                    "JOIN cartproducts cp ON cp.idcart = c.id JOIN product p ON p.id = cp.idproduct WHERE c.closed = TRUE " +
                    "AND c.idclient = "+user.getId());
            while (rs.next()) {
                products.put(fromResultSet(rs), rs.getInt("idcp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static Product fromResultSet(ResultSet rs) {
        try {
            return new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
                    rs.getDouble("price"), rs.getInt("idClient"), rs.getString("thumbnail"),
                    rs.getInt("stock"), rs.getInt("visits"), rs.getInt("sold"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save() {
        try {
            int count = DatabaseService.getInstance().getSt().executeUpdate(String.format(Locale.ROOT, update, name, description, price,
                    user == null ? userId : user.getId(), thumbnail, stock, visits, sold, id));
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete() {
        try {
            int count = DatabaseService.getInstance().getSt().executeUpdate("DELETE FROM product WHERE id = "+id);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public boolean removeStock(int amount) {
        if(stock >= amount) {
            stock -= amount;
            return true;
        }
        return false;
    }

    public User getUser() {
        if(user == null)
            user = User.get(userId);
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

    public float getRating() {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery("SELECT avg(rating) FROM review WHERE idproduct = "+id);
            if(rs.next())
                return rs.getFloat(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Review> getReviews() {
        return Review.list(this);
    }

    public ArrayList<Picture> getPictures() {
        return Picture.list(this);
    }

    @Override
    public int hashCode() {
        return 17*id;
    }
}
