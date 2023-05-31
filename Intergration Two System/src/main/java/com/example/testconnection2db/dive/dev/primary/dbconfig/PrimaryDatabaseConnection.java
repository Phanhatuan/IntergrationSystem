package com.example.testconnection2db.dive.dev.primary.dbconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager",
        basePackages = {"com.example.testconnection2db.dive.dev.primary.repository"}
)
public class PrimaryDatabaseConnection {

    @Value("${spring.primary.datasource.url}")
    private String url;
    @Value("${spring.primary.datasource.username}")
    private String username;
    @Value("${spring.primary.datasource.password}")
    private String password;

    @Primary
    @Bean (name = "primaryDbDataSource")
    public DataSource primaryDbDataSource(){
        return DataSourceBuilder.create().url(url).username(username).password(password).build();
    }

    @Primary
    @Bean (name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            @Qualifier("primaryDbDataSource") DataSource primaryDataSource){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(primaryDataSource);
        em.setPackagesToScan("com.example.testconnection2db.dive.dev.primary.models");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager (
            @Qualifier ("primaryEntityManagerFactory")EntityManagerFactory primaryEntityManagerFactory){
        return new JpaTransactionManager(primaryEntityManagerFactory);
    }

}
