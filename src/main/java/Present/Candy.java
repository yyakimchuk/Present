package Present;

import java.io.Serializable;

public abstract class Candy implements Serializable {
    private double price;
    private double mass;
    private String name;
    private int id;

    public Candy(double price, double mass, String name) {
        this.price = price;
        this.mass = mass;
        this.name = name;

    }

    public double getPrice() {
        return price;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID " + id + " Название: " + name + " Масса: " + mass + " Цена: " + price;
    }
}

