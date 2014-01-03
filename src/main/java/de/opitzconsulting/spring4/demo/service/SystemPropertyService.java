package de.opitzconsulting.spring4.demo.service;

public class SystemPropertyService {

    public String getCurrentEnv() {
        return System.getProperty("env");
    }
}
