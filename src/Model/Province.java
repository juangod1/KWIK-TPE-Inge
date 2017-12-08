package Model;

public class Province {
    private int id;
    private String name;
    private Country country;

    public Province(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
