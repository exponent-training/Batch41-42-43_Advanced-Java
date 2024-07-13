package com.example.demo.config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.demo.model.Student;

@Configuration
public class DBAppConfig {

	
	@Value(value = "${db.driverClassName}")
	private String driver;
	
	@Value(value = "${db.url}")
	private String url;
	
	@Value(value = "${db.username}")
	private String uname;
	
	@Value(value = "${db.password}")
	private String pass;
	
	@Value(value = "${db.dialect}")
	private String dialect;
	
	@Value(value = "${db.show_sql}")
	private String sql;
	
	@Value(value = "${db.hbm2ddl}")
	private String hbm2ddl;

	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(uname);
		ds.setPassword(pass);
		return ds;
	}
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		
		sf.setDataSource(getDataSource());
		
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, dialect);
		properties.setProperty(Environment.SHOW_SQL, sql);
		properties.setProperty(Environment.HBM2DDL_AUTO, hbm2ddl);
		
		sf.setHibernateProperties(properties);
		
		sf.setAnnotatedClasses(Student.class);
		
		return sf;
	}
	
	
}
