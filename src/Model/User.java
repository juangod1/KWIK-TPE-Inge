package Model;


import java.util.ArrayList;

public class User implements Persistent{

    private int id;
    private String username, password, name, surname, email, docNum;
    private boolean enabled, confirmed, admin;
    private DocType doc;
    private Cart cart;
    private Country country;
    private City city;
    private Province province;
    private String adress,  postalCode, phone;


    private User(){}

    private User(int id, String docNum, String username, String password, String name, String surname, String email, boolean enabled,
                boolean confirmed, boolean admin, DocType doc, Cart cart, Country country, City city, Province province, String adress,
                 String postalCode, String phone, String phone2) {
        this.id = id;
        this.docNum = docNum;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.enabled = enabled;
        this.confirmed = confirmed;
        this.doc = doc;
        this.cart = cart;
        this.country = country;
        this.city = city;
        this.province = province;
        this.adress=adress;
        this.postalCode = postalCode;
        this.phone = phone;
        this.admin = admin;
    }

    public static User create(String docNum, String username, String password, String name, String surname, String email, boolean enabled,
                              boolean confirmed, boolean admin, DocType doc, Cart cart, Country country, City city, Province province, String adress,
                              String postalCode, String phone, String phone2) { //Factory :wink:

        return new User(0, docNum, username, password, name, surname, email, enabled, confirmed, admin, doc, cart, country, city,
                        province, adress, postalCode, phone,phone2);
    }

    public static User get(int id) {
        return new User();
    }

    public static User login(String username, String password) {
        return new User();
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

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
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

    public DocType getDoc() {
        return doc;
    }

    public void setDoc(DocType doc) {
        this.doc = doc;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<Product>();
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<Card>();
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

    public void setAdress(String adress){ this.adress=adress;}

    public String getAdress(){return  adress;}

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
