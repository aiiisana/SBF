package com.example.demo;

import com.example.demo.autowire.AutowireAppConfig;
import com.example.demo.autowire.FooService;
import com.example.demo.constructor_di.Config;
import com.example.demo.constructor_di.domain.Car;
import com.example.demo.scopes.config.ScopesConfig;
import com.example.demo.scopes.model.HelloMessageGenerator;
import com.example.demo.store.model.Store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

        //task1
        Car toyota = getCarFromXml();
        System.out.println(toyota);

        toyota = getCarFromJavaConfig();
        System.out.println(toyota);

        System.out.println();

        //task2
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");

        Store storeByConstructor = (Store) context.getBean("xml-store-by-constructor");
        Store storeBySetter = (Store) context.getBean("xml-store-by-setter");
        Store storeByAutowire = (Store) context.getBean("xml-store-by-autowire-name");
        Store storeBySetterLazy = (Store) context.getBean("xml-store-by-setter-lazy");

        System.out.println("Constructor Injection: " + storeByConstructor);
        System.out.println("Setter Injection: " + storeBySetter);
        System.out.println("Autowired by Name: " + storeByAutowire);
        System.out.println("Lazy Initialization: " + storeBySetterLazy);
        System.out.println();

        //task3
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireAppConfig.class);
        FooService fooService = ctx.getBean(FooService.class);
        fooService.doStuff();
        System.out.println();

        //task4
        testScopes();

    }

    private static Car getCarFromJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        return context.getBean(Car.class);
    }

    private static Car getCarFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructordi.xml");
        return context.getBean(Car.class);
    }

    private static void testScopes() {
        System.out.println("---Scopes---");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopesConfig.class);

        HelloMessageGenerator singletonA = context.getBean("singletonScopedBean", HelloMessageGenerator.class);
        HelloMessageGenerator singletonB = context.getBean("singletonScopedBean", HelloMessageGenerator.class);

        singletonA.setMessage("Singleton");
        System.out.println("Bean A: " + singletonA.getMessage());
        System.out.println("Bean B: " + singletonB.getMessage());
        System.out.println();

        HelloMessageGenerator prototypeA = context.getBean("prototypeScopedBean", HelloMessageGenerator.class);
        HelloMessageGenerator prototypeB = context.getBean("prototypeScopedBean", HelloMessageGenerator.class);

        prototypeA.setMessage("Prototype A");
        prototypeB.setMessage("Prototype B");
        System.out.println("Bean A: " + prototypeA.getMessage());
        System.out.println("Bean B: " + prototypeB.getMessage());

        context.close();
    }

}

