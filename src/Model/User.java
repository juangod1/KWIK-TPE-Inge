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

}
