package com.example.task2.springevents;

import org.springframework.context.ApplicationEvent;

class UserRemovedEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String name;

    UserRemovedEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
