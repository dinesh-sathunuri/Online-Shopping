package com.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan({"com.*"})
public class Config {
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver rvr =new InternalResourceViewResolver();
		rvr.setSuffix(".jsp");
		rvr.setPrefix("/WEB-INF/");
		return rvr;
	}
	@Bean
	public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dinesh");
        dataSource.setUsername("root");
        dataSource.setPassword("dinesh700");
        return dataSource;
    }
	 @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }
}
