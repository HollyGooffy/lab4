package ru.zadanie.second;

import ru.zadanie.first.Box;

public class DoPointInBox {
    static public <T> void putInBox(Box<PointBox<T>> box, T x, T y, T z){
        PointBox<T> point = new PointBox<>(x,y,z);

        // Кладем точку в коробку
        box.put(point);
    }
}
