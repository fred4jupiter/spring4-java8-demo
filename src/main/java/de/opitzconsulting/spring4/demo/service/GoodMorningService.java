package de.opitzconsulting.spring4.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GoodMorningService implements GreetingService<GoodMorning> {

    @Override
    public GoodMorning getGreeting() {
        return new GoodMorning();
    }
}
