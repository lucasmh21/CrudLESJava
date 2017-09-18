package br.com.fatec.configuracao;

import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JPAConfiguracao {
	 @Bean
	   public DataSource dataSource() {
	        DriverManagerDataSource datasource = new DriverManagerDataSource();
	        datasource.setDriverClassName("com.mysql.jdbc.Driver");
	        datasource.setUrl("jdbc:mysql://localhost:3306/crudLES");
	        datasource.setUsername("root");
	        datasource.setPassword("lucasmh21");
	        return datasource;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
	        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
	        lef.setDataSource(dataSource);
	        lef.setJpaVendorAdapter(jpaVendorAdapter);
	        lef.setPackagesToScan("br.com.fatec.model");
	        Properties jpaProperties = new Properties();
	        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
	        lef.setJpaProperties(jpaProperties);
	        return lef;
	    }

	    @Bean
	    public JpaVendorAdapter jpaVendorAdapter() {
	        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	        hibernateJpaVendorAdapter.setShowSql(true);
	        hibernateJpaVendorAdapter.setGenerateDdl(true);
	        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
	        return hibernateJpaVendorAdapter;
	    }
}
