package de.opitzconsulting.spring4.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SystemPropertyEnvironmentCondition implements Condition {

    private static final Logger LOG = LoggerFactory.getLogger(SystemPropertyEnvironmentCondition.class);

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return (System.getProperty("env") != null);
    }
}
