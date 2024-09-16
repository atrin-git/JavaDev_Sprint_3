package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static DinnerConstructor dc = new DinnerConstructor();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Общение с пользователем
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    /**
     * Печать меню
     */
    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    /**
     * Добавление нового блюда
     */
    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
    }

    /**
     * Генерация комбо-наборов
     */
    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> typesList = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (!dc.hasDishType(nextItem)) {
                System.out.println("Тип \"" + nextItem + "\" не содержится в меню. Введите другой.");
            } else {
                typesList.add(nextItem);
            }

            nextItem = scanner.nextLine();
        }

        if (typesList.isEmpty()) {
            System.out.println("Отсутствуют типы блюд для создания комбо.");
            return;
        }

        dc.printDishComboList(dc.generateDishComboList(numberOfCombos, typesList));

    }
}
