package Model;

import java.util.ArrayList;

public class Card implements Persistent{
    private int id;
    private User user;
    private String name;
    private String surname;
    private String number;
    private int day;
    private int month;
    private int code;

    private Card() {}

    private Card(int id, User user, String name, String surname, String number, int day, int month, int code) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.day = day;
        this.month = month;
        this.code = code;
    }

    public static Card create(User user, String name, String surname, String number, int month, int year, int code) {
        return new Card(0, user, name, surname, number,  month, year, code);

    }

    public static Card get(int id) {
        return new Card();
    }

    public static ArrayList<Card> getUserCards(User user) {
        return new ArrayList<>();
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
