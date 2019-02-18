package com.cisco.user.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.SessionFactory;

@Configuration
@EnableTransactionManagement
@ImportResource({"classpath:session-factory-context.xml"})
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

    /*@Autowired
    private Environment environment;


    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory getSessionFactory() {
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }*/

   /* @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder  sessionFactory = new LocalSessionFactoryBuilder(dataSource());

        sessionFactory.scanPackages("com.cisco.user.model")
                .addProperties(hibernateProperties());

       *//* return builder.buildSessionFactory();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.cisco.user.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());*//*
        return sessionFactory.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:TEST;MVCC=true;DB_CLOSE_DELAY=-1;MODE=Oracle");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.show_sql", true);
       // properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory());
        return txManager;
    }*/
}