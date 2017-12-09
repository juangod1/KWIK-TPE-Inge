package Model;


import Service.DatabaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User implements Persistent{

    private int id;
    private String username, password, name, surname, email, doc;
    private boolean enabled, confirmed, admin;
    private DocType docType;
    private Country country;
    private City city;
    private Province province;
    private String address,  postCode, phone, phone2;

    private static final String select = "SELECT u.*, d.name as docName, c.name as countryName, p.name as provinceName, city.name as cityName " +
            "FROM client u JOIN doctype d ON d.id = u.iddoctype JOIN country c ON c.id = u.idcountry " +
            "JOIN province p ON p.id = u.idprovince JOIN city ON city.id = u.idcity ";


    private User(){}

    private User(int id, String doc, String username, String password, String name, String surname, String email, boolean enabled,
                boolean confirmed, boolean admin, DocType docType, Cart cart, Country country, City city, Province province, String address,
                 String postCode, String phone, String phone2) {
        this.id = id;
        this.doc = doc;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.enabled = enabled;
        this.confirmed = confirmed;
        this.docType = docType;
        this.country = country;
        this.city = city;
        this.province = province;
        this.address = address;
        this.postCode = postCode;
        this.phone = phone;
        this.phone2 = phone2;
        this.admin = admin;
    }

    public static User create(String doc, String username, String password, String name, String surname, String email, boolean enabled,
                              boolean confirmed, boolean admin, DocType docType, Cart cart, Country country, City city, Province province,
                              String address, String postCode, String phone, String phone2) { //Factory :wink:

        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery("INSERT INTO client (username, password, name, surname," +
                    " email, iddoctype, idcountry, idprovince, idcity, postcode, phone, enabled, confirmed, admin, doc, phone2, address) " +
                    "VALUES ('"+username+"', '"+password+"', '"+name+"', '"+surname+"', '"+email+"', "+docType.getId()+", "+country.getId()+
                    ", "+province.getId()+", "+city.getId()+", '"+postCode+"', '"+phone+"', "+enabled+", "+confirmed+", "+admin+", '"+doc+
                    "', '"+phone2+"', '"+address+"') RETURNING id");

            if(rs.next())
                return new User(rs.getInt(1), doc, username, password, name, surname, email, enabled, confirmed, admin, docType,
                        cart, country, city, province, address, postCode, phone, phone2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User get(int id) {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery( select + "WHERE u.id = "+ id);
            if(rs.next()) {
                return fromResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static User login(String username, String password) {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery( select +
                    "WHERE username = '"+ username +"' AND password = '"+ password +"'");
            if(rs.next()) {
                return fromResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public static ArrayList<User> list() {
        ArrayList<User> users = new ArrayList<>();
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select);
            while (rs.next()) {
                users.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static User fromResultSet(ResultSet rs) {
        try {
            DocType docType = new DocType(rs.getInt("iddoctype"), rs.getString("docName"));
            Country country = new Country(rs.getInt("idcountry"), rs.getString("countryName"));
            Province province = new Province(rs.getInt("idprovince"), rs.getString("provinceName"), country);
            City city = new City(rs.getInt("idcity"), rs.getString("cityName"), province);

            return new User(rs.getInt("id"), rs.getString("doc"), rs.getString("username"),
                    rs.getString("password"), rs.getString("name"), rs.getString("surname"),
                    rs.getString("email"), rs.getBoolean("enabled"), rs.getBoolean("confirmed"),
                    rs.getBoolean("admin"), docType, null, country, city, province, rs.getString("address"),
                    rs.getString("postCode"), rs.getString("phone"), rs.getString("phone2"));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    public boolean validateLogin(){
        return true;
    }

    public int getId() {
        return id;
    }

    public String getdoc() {
        return doc;
    }

    public void setdoc(String doc) {
        this.doc = doc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public Cart getCart() {
        return Cart.getUserCart(this);
    }

    public ArrayList<Product> getProducts() {
        return Product.getByUser(this);
    }

    public ArrayList<Card> getCards() {
        return Card.getByUser(this);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public void setaddress(String address){
        this.address = address;
    }

    public String getaddress(){
        return address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone) {
        this.phone2 = phone;
    }
}
