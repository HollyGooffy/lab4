package ru.zadanie.third_3;

public interface Reducer<T> {
    T apply (T t1, T t2);
}
