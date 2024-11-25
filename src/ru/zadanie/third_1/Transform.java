package ru.zadanie.third_1;

import java.util.ArrayList;
import java.util.List;

public class Transform {
    public static <T, P> List<P> transform(List<T> list, Apply<T, P> func) {
        List<P> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            result.add(func.apply(item));
        }
        return result;
    }
}
