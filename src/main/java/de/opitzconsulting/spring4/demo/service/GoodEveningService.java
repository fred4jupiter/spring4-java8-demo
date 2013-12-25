package de.opitzconsulting.spring4.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GoodEveningService implements GreetingService<GoodEvening> {

    @Override
    public GoodEvening getGreeting() {
        return new GoodEvening();
    }
}
