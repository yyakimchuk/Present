package Present;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Present implements Serializable {
    private List<Candy> gift;
    private int id;

    public Present() {
        this.id = 0;
        this.gift = new ArrayList<Candy>();
    }

    public double getMass() {
        double summMass = 0;
        for (Candy candy : gift) {
            summMass += candy.getMass();
        }
        return summMass;
    }

    public double getPrice() {
        double summPrice = 0;
        for (Candy candy : gift) {
            summPrice += candy.getPrice();
        }
        return summPrice;
    }

    public void addCandyToMy(Candy candy) {
        id++;
        candy.setId(id);
        gift.add(candy);
        System.out.println("Добавлен: " + candy);
    }

    public void dellCandyInMy(int id) {
        if (id > 0) {
            int temp = -1;
            for (int i = 0; i < gift.size(); i++) {
                int tempId = gift.get(i).getId();
                if (tempId == id) temp = i;

            }
            if (temp != -1) {
                gift.remove(temp);
                System.out.println("ID -" + id + " удален");
            } else
                System.out.println("ID -" + id + " не существует");
        } else System.out.println("Id не может быть отрицательным или ноль.");
    }

    public void print() {
        for (Candy a : gift) {
            System.out.println(a);
        }
        System.out.println("Общая сумма подарка: " + getPrice() + "\nОбщая масса подарка: " + getMass());
    }

    public boolean isEmpty() {
        return gift.isEmpty();
    }

    public void writeToFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Candy> getList() {
        return gift;
    }
}
