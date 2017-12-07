package Model;

public class Card {
    private int ID;
    private User user;
    private String name;
    private String surname;
    private String number;
    private int day;
    private int month;
    private int code;

    public Card(int ID, User user, String name, String surname, String number, int day, int month, int code) {
        this.ID = ID;
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.day = day;
        this.month = month;
        this.code = code;
    }
}
