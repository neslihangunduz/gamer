package org.turkcell;

public class Game {
    private static int id_counter =1;
    private final int id;
    private String name;
    private double price;

    public Game(String name, double price) {
        this.id = id_counter++;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                "}\n\t";
    }
}
