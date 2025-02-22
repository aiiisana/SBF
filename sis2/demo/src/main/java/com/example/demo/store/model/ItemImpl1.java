package com.example.demo.store.model;

import org.springframework.stereotype.Component;

@Component("item1")
public class ItemImpl1 implements Item {
    @Override
    public String getName() {
        return "ItemImpl1";
    }
}
