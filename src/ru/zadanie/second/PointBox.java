package ru.zadanie.second;

public class PointBox<T> {
    private T x;
    private T y;
    private T z;

    public PointBox(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public T getZ() {
        return z;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

}