package com.example.demo.events.sync;

public class GenericSpringEvent<T> {
    private final T data;

    public GenericSpringEvent(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
