package com.example.demo.store.config;

import com.example.demo.store.model.Item;
import com.example.demo.store.model.ItemImpl1;
import com.example.demo.store.model.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Item item1() {
        return new ItemImpl1();
    }

    @Bean
    public Store storeThroughConstructorInjection() {
        return new Store(item1());
    }

    @Bean
    public Store storeThroughSetterInjection() {
        Store store = new Store();
        store.setItem(item1());
        return store;
    }
}
