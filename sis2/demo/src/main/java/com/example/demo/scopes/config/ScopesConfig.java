package com.example.demo.scopes.config;

import com.example.demo.scopes.model.HelloMessageGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class ScopesConfig {

    @Bean
    @Scope("singleton")
    public HelloMessageGenerator singletonScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope("prototype")
    public HelloMessageGenerator prototypeScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean(name = "customRequestScopedBean")
    @Scope(WebApplicationContext.SCOPE_REQUEST)
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean(name = "customSessionScopedBean")
    @Scope(WebApplicationContext.SCOPE_SESSION)
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean(name = "customAppScopedBean")
    @Scope(WebApplicationContext.SCOPE_APPLICATION)
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }
}
