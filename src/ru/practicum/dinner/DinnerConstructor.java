package ru.practicum.dinner;

import java.util.*;

/**
 * Класс для работы с меню ресторана и контруктор обедов
 */
public class DinnerConstructor {

    /**
     * Меню в формате {тип блюда => список блюд}
     */
    private final HashMap<String, ArrayList<String>> menu;
    private final Random randomizer;

    /**
     * Создание объекта класса DinnerConstructor
     */
    public DinnerConstructor() {
        this.menu = new HashMap<>();
        this.randomizer = new Random();
    }

    /**
     * Добавление нового блюда в меню
     *
     * @param type Тип блюда
     * @param name Наименование блюда
     */
    public void addNewDish(String type, String name) {
        ArrayList<String> currentTypeDishesList = menu.computeIfAbsent(type, k -> new ArrayList<>());

        if (currentTypeDishesList.contains(name)) {
            System.out.println("Блюдо уже было добавлено ранее");
            return;
        }
        currentTypeDishesList.add(name);
        menu.put(type, currentTypeDishesList);

        System.out.println("Блюдо " + name + " с типом " + type + " добавлено в меню.");
    }

    /**
     * Генерация комбо-наборов
     *
     * @param numberOfCombos Количество наборов
     * @param typesList      Типы блюд
     * @return Список комбо-наборов
     */
    public ArrayList<DishCombo> generateDishComboList(int numberOfCombos, ArrayList<String> typesList) {
        ArrayList<DishCombo> dishComboList = new ArrayList<>(numberOfCombos);

        for (int i = 0; i < numberOfCombos; i++) {
            dishComboList.add(generateDishCombo(typesList));
        }

        return dishComboList;
    }

    /**
     * Генерация одного комбо-набора
     *
     * @param typesList Типы блюд
     * @return Комбо-набор
     */
    private DishCombo generateDishCombo(ArrayList<String> typesList) {
        DishCombo dishCombo = new DishCombo(typesList.size());

        for (String type : typesList) {
            dishCombo.add(getRandomDishByType(type));
        }

        return dishCombo;
    }

    /**
     * Получение рандомного блюда выбранного типа
     *
     * @param type Тип блюда
     * @return Блюдо
     */
    private String getRandomDishByType(String type) {
        ArrayList<String> dishesCurrentType = menu.get(type);
        int randomId = randomizer.nextInt(dishesCurrentType.size());

        return dishesCurrentType.get(randomId);
    }

    /**
     * Печать списка комбо-наборов
     *
     * @param dishComboList Список комбо-наборов
     */
    public void printDishComboList(ArrayList<DishCombo> dishComboList) {
        for (int i = 0; i < dishComboList.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            dishComboList.get(i).print();
        }
    }

    /**
     * Проверка на наличие типа блюд в меню
     *
     * @param type Тип блюда
     * @return true - тип есть в меню, false - тип отсутствует
     */
    public boolean hasDishType(String type) {
        return menu.containsKey(type);
    }
}
