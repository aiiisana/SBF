package com.example.task2.springevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class Publisher {
    private final ApplicationEventPublisher publisher;
    private final AsyncListener asyncListener;

    @Autowired
    Publisher(ApplicationEventPublisher publisher, AsyncListener asyncListener) {
        this.publisher = publisher;
        this.asyncListener = asyncListener;
    }

    void publishEvent() {
        publisher.publishEvent("I'm Async from task2");
        publisher.publishEvent(new UserCreatedEvent(this, "Lucario"));
        publisher.publishEvent(new UserRemovedEvent(this, "Lucario"));
        publisher.publishEvent(new UserCreatedEvent(this, "reflectoring"));
        publisher.publishEvent(new UserRemovedEvent(this, "reflectoring"));
    }
}
