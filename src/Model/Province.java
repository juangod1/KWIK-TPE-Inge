package Model;

import java.util.ArrayList;

public class Province {
    private int id;
    private String name;
    private Country country;

    private Province(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public static Province get(int id) {
        return new Province(0, "bs as", null);
    }

    public static ArrayList<Province> list() {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
