package com.example.demo.constructor_di;

import com.example.demo.constructor_di.domain.Engine;
import com.example.demo.constructor_di.domain.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.constructor_di.domain")
public class Config {

    @Bean
    public Engine engine() {
        return new Engine("V8", 5);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }
}
