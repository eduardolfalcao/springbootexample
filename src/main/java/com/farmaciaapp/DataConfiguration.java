package com.farmaciaapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	enum BD {MYSQL, POSTGRES}
	
	private BD bdTechnology = BD.MYSQL;

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setPassword("edu123sql");
		if(bdTechnology == BD.MYSQL){		
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/farmaciaapp");
			dataSource.setUsername("root");			
		} else if(bdTechnology == BD.POSTGRES){
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/farmaciaapp");
			dataSource.setUsername("postgres");
		}
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		if(bdTechnology == BD.MYSQL){		
			adapter.setDatabase(Database.MYSQL);
			adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		} else if(bdTechnology == BD.POSTGRES){
			adapter.setDatabase(Database.POSTGRESQL);
			adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		}
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setPrepareConnection(true);
		return adapter;
	}
	
}
