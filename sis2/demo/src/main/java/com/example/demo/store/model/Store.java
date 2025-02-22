package com.example.demo.store.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Store {

    @Autowired
    private Item item;

    public Store(Item item) {
        this.item = item;
    }

    public Store() {}

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}