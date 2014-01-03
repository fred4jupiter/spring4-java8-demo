package de.opitzconsulting.spring4.demo.config;

import de.opitzconsulting.spring4.demo.service.SchedulingService;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"de.opitzconsulting.spring4.demo.service"})
@EnableJpaRepositories(basePackages = "de.opitzconsulting.spring4.demo.repository")
@PropertySource("classpath:/hibernate-config.properties")
@EnableTransactionManagement
@EnableScheduling
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    @Description("This is the dataSource of embedded H2 database")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("de.opitzconsulting.spring4.demo.domain");
        factory.setDataSource(dataSource);
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setJpaProperties(jpaProperties());

        factory.afterPropertiesSet();

        return factory.getObject();
    }

    private Properties jpaProperties() {
        Properties extraProperties = new Properties();
        extraProperties.put("hibernate.format_sql", "true");
        extraProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        extraProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        return extraProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager) {
        return new TransactionTemplate(platformTransactionManager);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Conditional(ActivateSchedulingCondition.class)
    public SchedulingService schedulingService() {
        return new SchedulingService();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
