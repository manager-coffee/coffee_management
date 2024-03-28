package model;

public class User {
    private int id;
    private String name;
    private int number;
    private String country;



    public User() {
    }

    public User(int id, String name, int number, String country) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.country = country;
    }

    public User(String name, int number, String country) {
        this.name = name;
        this.number = number;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
