package com.example.demo;

import com.example.demo.scopes.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class BeanScopesTest {

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        Person personSingletonA = applicationContext.getBean("personSingleton", Person.class);
        Person personSingletonB = applicationContext.getBean("personSingleton", Person.class);

        personSingletonA.setName(NAME);
        Assertions.assertEquals(NAME, personSingletonB.getName());
    }

    @Test
    public void givenPrototypeScope_whenSetNames_thenDifferentNames() {
        Person personPrototypeA = applicationContext.getBean("personPrototype", Person.class);
        Person personPrototypeB = applicationContext.getBean("personPrototype", Person.class);

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        Assertions.assertEquals(NAME, personPrototypeA.getName());
        Assertions.assertEquals(NAME_OTHER, personPrototypeB.getName());
    }
}