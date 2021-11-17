package com.tutorial.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Profile(value = { "multi" })
public class MultipleDbConfig {

	@Primary
	@Bean(name = "mysql")
	@ConfigurationProperties(prefix = "spring.datasource-mysql")
	public DataSource mySqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlTemplate")
	public JdbcTemplate mySqlTemplate(@Qualifier("mysql") DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean(name = "postgres")
	@ConfigurationProperties(prefix = "spring.datasource-postgres")
	public DataSource postgresSqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresTemplate")
	public JdbcTemplate postgresTemplate(@Qualifier("postgres") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
