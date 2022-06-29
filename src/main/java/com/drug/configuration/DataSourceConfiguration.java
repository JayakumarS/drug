package com.drug.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

public class DataSourceConfiguration  {

	
	@Value("${spring.datasource.url}")
	public String databaseUrl;
	
	@Value("${spring.datasource.username}")
	public String dbUserName;
	
	@Value("${spring.datasource.password}")
	public String dbPassword;
	
	@Value("${spring.datasource.driver-class-name}")
	public String driverClassName;
	
	
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(databaseUrl);
        dataSourceBuilder.username(dbUserName);
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();
    }
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
	    return new NamedParameterJdbcTemplate(dataSource);
	}
	
	
}
