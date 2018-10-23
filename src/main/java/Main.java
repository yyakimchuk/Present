import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        String defaultName = String.valueOf(new Random().nextInt(1000))+".present";
        Present.Present myPresent = new Present.Present();
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        int menyTipe;
        boolean cicle = true;
        while (cicle) {
            try {
                System.out.println("Выберете пункт меню:\n1 - Добавление/Формирование сладости в подарки, " +
                        "\n2 - Вывод списка сладостей в подарке, \n3 - Удаление сладости из подарка.");
                menyTipe = Integer.parseInt(brr.readLine());
                switch (menyTipe) {
                    case 1:
                        addCandyToGift(myPresent);
                        break;
                    case 2:
                        if (myPresent.isEmpty()) {
                            System.out.println("Список сладостей пуст");
                        } else {
                            myPresent.print();
                        }
                        break;
                    case 3:
                        if (myPresent.isEmpty()) {
                            System.out.println("Список сладостей пуст");
                        } else {
                            delCandyFromGift(myPresent);
                        }
                        break;
                    default:
                        System.out.println("Введен не верный пунк меню");
                        continue;
                }
                System.out.println("Выбрать другой пункт меню? (Да/Нет)");
                String answer = brr.readLine();
                if (!answer.equalsIgnoreCase("да")) {
                    cicle = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введен не корректный номер меню");
                mainMenu();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addCandyToGift(Present.Present myPresent) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int candyType;
            String name;
            double price;
            double mass;
            try {
                System.out.println("Выберите сладость (1-мармелад, 2-щербет, 3-козинак, 4-халва):");
                candyType = Integer.parseInt(br.readLine());
                System.out.println("Укажите название сладости:");
                name = br.readLine();
                System.out.println("Укажите цену:");
                price = Double.parseDouble(br.readLine());
                if (price < 0) {
                    System.out.println("Введена отрицательная цена сладости!");
                    break;
                }
                System.out.println("Укажите массу сладости:");
                mass = Double.parseDouble(br.readLine());
                if (mass <= 0) {
                    System.out.println("Введена отрицательная или нулевая масса сладости!");
                    break;
                }
                switch (candyType) {
                    case 1:
                        myPresent.addCandyToMy(new Present.Marmalade(price, mass, name));
                        break;
                    case 2:
                        myPresent.addCandyToMy(new Present.Sherbet(price, mass, name));
                        break;
                    case 3:
                        myPresent.addCandyToMy(new Present.Kozinak(price, mass, name));
                        break;
                    case 4:
                        myPresent.addCandyToMy(new Present.Halva(price, mass, name));
                        break;
                    default:
                        System.out.println("Не верно веден тип сладости!");
                        continue;
                }
                System.out.println("Добавить еще сладость?(Да/Нет)");
                if (!br.readLine().equalsIgnoreCase("да")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Не верно введен параметр! Сладость не добавлена! Начните сначала.");
                addCandyToGift(myPresent);
            }
        }
    }

    private static void delCandyFromGift(Present.Present myPresent) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Введите уникальный номер удаляемой сладости: ");
                myPresent.dellCandyInMy(Integer.parseInt(br.readLine()));
                System.out.println("Удалить еще сладость?(Да/Нет)");
                if (!br.readLine().equalsIgnoreCase("да")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Введен не корректный уникальный номер сладости!");
            }
        }
    }
}
