package com.example.task2.springevents;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
class UserCreatedListener implements ApplicationListener<UserCreatedEvent> {

    @Override
    public void onApplicationEvent(UserCreatedEvent event) {
        System.out.printf("User created from task2: %s%n", event.getName());
    }
}
