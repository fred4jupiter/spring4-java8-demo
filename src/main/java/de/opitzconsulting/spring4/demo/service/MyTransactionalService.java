package de.opitzconsulting.spring4.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Service
@Transactional(rollbackFor = Exception.class)
public @interface MyTransactionalService {
    String[] value() default "";

    Propagation propagation() default Propagation.REQUIRED;

    int timeout() default TransactionDefinition.TIMEOUT_DEFAULT;
}
