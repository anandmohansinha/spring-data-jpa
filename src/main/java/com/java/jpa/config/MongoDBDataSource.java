package com.java.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mondodbEmFactory", transactionManagerRef = "mongodbTransactionManager"
                      ,basePackages="{com.java.jpa.repository.mongodb}")
public class MongoDBDataSource {

    @Primary
    @Bean
    @ConfigurationProperties("spring.data.mongodb")
    public DataSourceProperties mongodbProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource mongodbDataSource(@Qualifier("mongodbProperties") DataSourceProperties dp){
       return dp.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean mondodbEmFactory(
            @Qualifier("mongodbDataSource") DataSource dataSource
            , EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource).packages("com.java.jpa.entity.mongodb").build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager mongodbTransactionManager(
            @Qualifier("mondodbEmFactory") EntityManagerFactory em){
        return new JpaTransactionManager(em);
    }
}