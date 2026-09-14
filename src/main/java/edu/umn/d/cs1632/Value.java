package edu.umn.d.cs1632;

public abstract class Value<T> {
    protected T value;

    public Value(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


}
