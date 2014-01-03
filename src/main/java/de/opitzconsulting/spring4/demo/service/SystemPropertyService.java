package de.opitzconsulting.spring4.demo.service;

import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

public class SystemPropertyService {

    private final Environment environment;

    public SystemPropertyService(Environment environment) {
        this.environment = environment;
    }

    public boolean isProfileActive(String env) {
        return environment.acceptsProfiles(env);
    }
}
