package Model;

import Service.DatabaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cart implements Persistent {
    private int id;
    private User user;
    private boolean closed;
    private double subTotal;
    private Card card;

    private int userId;
    private int cardId;

    private Cart() {}

    private Cart(int id, User user, boolean closed, double subTotal, Card card){
        this.id = id;
        this.closed = closed;
        this.card = card;
        this.user = user;
        this.subTotal = subTotal;
    }

    private Cart(int id, int userId, boolean closed, double subTotal, int cardId){
        this.id = id;
        this.closed = closed;
        this.cardId = cardId;
        this.card = null;
        this.userId = userId;
        this.user = null;
        this.subTotal = subTotal;
    }

    private static final String select = "SELECT * FROM cart ";

    public static Cart create(User user) {
        Cart currentCart = getUserCart(user);
        if(currentCart != null)
            return currentCart;

        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery("INSERT INTO cart (idclient) " +
                    "VALUES ("+user.getId()+") RETURNING id");
            if(rs.next())
                return new Cart(rs.getInt(1), user, false, 0, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Cart get(int id) {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select + "WHERE id = "+id);
            if(rs.next())
                return fromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Cart getUserCart(User user) {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select + "WHERE idclient = "+user.getId()+" AND closed = FALSE");
            if(rs.next())
                return fromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Cart> closedCarts(User user) {
        ArrayList<Cart> carts = new ArrayList<>();
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select + "WHERE idclient = "+user.getId()+" AND closed = TRUE");
            while (rs.next())
                carts.add(fromResultSet(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }

    private static Cart fromResultSet(ResultSet rs) {
        try {
            return new Cart(rs.getInt("id"), rs.getInt("idClient"), rs.getBoolean("closed"),
                    rs.getDouble("subtotal"), rs.getInt("idCard"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery("SELECT p.* FROM cart c " +
                    "JOIN cartproducts cp ON cp.idcart = c.id JOIN product p ON p.id = cp.idproduct");
            while (rs.next()) {
                products.add(Product.fromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean addProduct(Product product, int amount) {
        if(amount < 1)
            return false;

        try {
            Statement st = DatabaseService.getInstance().getSt();
            ResultSet rs = st.executeQuery("SELECT amount FROM cartproducts WHERE idcart = "+id+" AND idproduct = "+product.getId());
            if(rs.next())
                st.execute("UPDATE cartproducts SET amount = amount + "+amount+" WHERE idcart = "+id);
            else
                st.execute("INSERT INTO cartproducts (idcart, idproduct, amount) VALUES ("+id+", "+product.getId()+", "+amount+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        try {
            Statement st = DatabaseService.getInstance().getSt();
            ResultSet rs = st.executeQuery("SELECT amount FROM cartproducts WHERE idcart = "+id+" AND idproduct = "+product.getId());
            if(rs.next()) {
                st.execute("DELETE FROM cartproducts WHERE id = "+rs.getInt(1));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public User getUser() {
        if(user == null)
            user = User.get(userId);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isClosed() {
        return closed;
    }

    public void close(){
        closed = true;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Card getCard() {
        if(card == null)
            card = Card.get(cardId);
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
