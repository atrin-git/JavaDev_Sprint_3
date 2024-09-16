package ru.practicum.dinner;

import java.util.ArrayList;

/**
 * Класс для списка блюд из комбо-набора
 */
public class DishCombo {

    /**
     * Список блюд из комбо-набора
     */
    private final ArrayList<String> dishCombo;

    /**
     * Создание комбо-набора
     *
     * @param size Количество блюд в наборе
     */
    public DishCombo(int size) {
        dishCombo = new ArrayList<>(size);
    }

    /**
     * Добавление блюда в набор
     *
     * @param dish Наименование блюда
     */
    public void add(String dish) {
        dishCombo.add(dish);
    }

    /**
     * Печать комбо-набора
     */
    public void print() {
        System.out.println(dishCombo);
    }

}
