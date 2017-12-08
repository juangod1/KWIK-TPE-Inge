package Model;

public class City {
    private int id;
    private String name;
    private Province province;

    public City(int id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province = province;
    }
}
