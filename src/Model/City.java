package Model;

public class City {
    private int ID;
    private String name;
    private Province province;

    public City(int ID, String name, Model.Province province) {
        this.ID = ID;
        this.name = name;
        this.province = province;
    }
}
