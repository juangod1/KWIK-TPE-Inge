package Model;

import java.util.ArrayList;

public class City {
    private int id;
    private String name;
    private Province province;

    private City() {}

    public City(int id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province = province;
    }

    public static City get(int id) {
        return new City(0, "oal", null);
    }

    public static ArrayList<City> list() {
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
