package ru.zadanie.third_3;

import java.util.List;

public class Reduce {
    public static <T> T reduce(List<T> list, Reducer<T> reducer, T ident){
        if(list == null || list.isEmpty()){
            return ident;
        }
        T result = ident;
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            result = reducer.apply(result, item);
        }
        return result;
    }

}
