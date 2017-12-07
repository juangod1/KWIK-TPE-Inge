package Model;

import java.util.ArrayList;

public class User {
    private static class Address{
        Country country;
        City city; // Replacement for "County"
        Province province; // Replacement for "state"
        String street, streetNum, apartment, postalCode, phone;
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
