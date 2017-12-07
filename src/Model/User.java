package Model;

import java.util.ArrayList;

public class User {
    private static class Address{
        Country country;
        City city; // Replacement for "County"
        Province province; // Replacement for "state"
        String street, streetNum, apartment, postalCode, phone;

        public Address(Country country, City city, Province province, String street, String streetNum, String apartment, String postalCode, String phone) {
            this.country = country;
            this.city = city;
            this.province = province;
            this.street = street;
            this.streetNum = streetNum;
            this.apartment = apartment;
            this.postalCode = postalCode;
            this.phone = phone;
        }
    }

    public User(){

    }

    public User(int ID, int docNum, String username, String password, String name, String surname, String email, boolean enabled, boolean confirmed, DocType doc, Cart cart) {
        this.ID = ID;
        this.docNum = docNum;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.addressList = addressList;
        this.enabled = enabled;
        this.confirmed = confirmed;
        this.doc = doc;
        this.cart = cart;
        this.products = products;
        addressList = new ArrayList<>();
        products = new ArrayList<>();
    }

    private int ID, docNum;
    private String username, password, name, surname, email;
    private ArrayList<Address> addressList;
    private boolean enabled, confirmed;
    private DocType doc;
    private Cart cart;
    private ArrayList<Product> products;

    public boolean validateLogin(){
        return true;
    }

    public boolean addProduct(int ID, String name, String description, double price, User user, String thumbnail, int stock){
        products.add(new Product(ID, name, description, price, user, thumbnail, stock));
        return true;
    }

    public void setEnabled(boolean bool){
        enabled = bool;
    }
}
