package ru.zadanie.first;

public class Storage<T> {
    private T value;
    private T alternativeValue;

    public Storage(T value, T alternativeValue) {
        this.value = value;
        this.alternativeValue = alternativeValue;
    }

    public T getValue() {
        if (value != null) {
            return value;
        } else {
            return alternativeValue;
        }
    }
}