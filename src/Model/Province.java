package Model;

public class Province {
    private int ID;
    private String name;
    private Country country;

    public Province(int ID, String name, Country country) {
        this.ID = ID;
        this.name = name;
        this.country = country;
    }
}
