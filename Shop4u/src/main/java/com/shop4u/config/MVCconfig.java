package com.shop4u.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@PropertySource(value = "classpath:db.properties")
public class MVCconfig extends WebMvcConfigurerAdapter {
	@Autowired
	Environment environment ;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/DATA/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/template/**").addResourceLocations("/template/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean(value = "GetDataSource")
	public javax.sql.DataSource GetDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/english4u");
		dataSource.setUsername("root");
		dataSource.setPassword("admin123");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean factoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(GetDataSource());
		// chua cac class,cac class nay se map voi data base
		sessionFactoryBean.setPackagesToScan("com.shop4u.entity");

		Properties hibernateProperties = new Properties();
		// cho phep lam viec voi cac loai data base khac nhau
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		// cho phep hien thi cac cau lenh tren console
		hibernateProperties.put("hibernate.show_sql", true);

		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;

	}

	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory hi) {
		HibernateTransactionManager HRM = new HibernateTransactionManager();
		HRM.setSessionFactory(hi);
		return HRM;
	}

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		//bundleMessageSource.setBasename("classpath:messages/messages");
		bundleMessageSource.setDefaultEncoding("utf-8");

		return bundleMessageSource;
	}
}
