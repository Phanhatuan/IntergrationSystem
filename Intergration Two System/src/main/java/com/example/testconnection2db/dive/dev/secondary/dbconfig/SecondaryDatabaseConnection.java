package com.example.testconnection2db.dive.dev.secondary.dbconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager",
        basePackages = {"com.example.testconnection2db.dive.dev.secondary.repo"}
)
public class SecondaryDatabaseConnection {


    @Value("${spring.secondary.datasource.url}")
    private String url;
    @Value("${spring.secondary.datasource.username}")
    private String username;
    @Value("${spring.secondary.datasource.password}")
    private String password;

    @Bean (name = "secondaryDbDataSource")
    public DataSource secondaryDbDataSource(){
        return DataSourceBuilder.create().url(url).username(username).password(password).build();
    }

    @Bean (name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            @Qualifier("secondaryDbDataSource") DataSource secondaryDataSource){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(secondaryDataSource);
        em.setPersistenceUnitName("secondary");
        em.setPackagesToScan("com.example.testconnection2db.dive.dev.secondary.models");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager (
            @Qualifier ("secondaryEntityManagerFactory")EntityManagerFactory secondaryEntityManagerFactory){
        return new JpaTransactionManager(secondaryEntityManagerFactory);
    }

}
