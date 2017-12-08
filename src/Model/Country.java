package Model;

import java.util.ArrayList;

public class Country {
    private int id;
    private String name;

    private Country() {}

    private Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Country get(int id) {
        return new Country(0, "arg");
    }

    public static ArrayList<Country> list() {
        return new ArrayList<>();
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
}
