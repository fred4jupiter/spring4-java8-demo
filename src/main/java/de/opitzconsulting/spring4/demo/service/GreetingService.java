package de.opitzconsulting.spring4.demo.service;


public interface GreetingService<T> {

    T getGreeting();
}
