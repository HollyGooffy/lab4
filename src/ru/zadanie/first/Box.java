package ru.zadanie.first;

public class Box<T> {
    private T value;

    public void put(T value){
        if(this.value != null ){
            throw new IllegalStateException("Box is not empty");
        }
        this.value = value;
    }

    public T get(){
        T temp = value;
        value = null;
        return temp;
    }

    public boolean isEmpty(){
        return value == null;
    }

}