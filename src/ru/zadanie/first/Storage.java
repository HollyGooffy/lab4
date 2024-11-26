package ru.zadanie.first;

public class Storage<T> {
    private T value;
    private T alternativeValue;
    // должно быть одно значение

    public Storage(T value, T alternativeValue) {
        this.value = value;
        this.alternativeValue = alternativeValue;
        // должно быть одно значение
    }

    public T getValue() {
        if (value != null) {
            return value;
        } else {
            return alternativeValue;
        }
    }
}