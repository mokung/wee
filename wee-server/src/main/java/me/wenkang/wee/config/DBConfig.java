package me.wenkang.wee.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by wenkang
 * on 2017/9/30.
 */
@SpringBootConfiguration
@Slf4j
public class DBConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.connectionTimeout}")
    private int connectionTimeout;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.maxLifetime}")
    private int maxLifetime;

    @Value("${spring.datasource.connectionInitSql}")
    private String connectionInitSql;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        HikariDataSource datasource= new HikariDataSource();

        datasource.setDriverClassName(driverClassName);
        datasource.setJdbcUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);

        datasource.setConnectionInitSql(connectionInitSql);
        datasource.setConnectionTimeout(connectionTimeout);
        datasource.setMaxLifetime(maxLifetime);
        datasource.setConnectionTestQuery(validationQuery);
        datasource.setMinimumIdle(minIdle);
        datasource.setMaximumPoolSize(maxActive);
        datasource.setPoolName("dataPool");
        return datasource;
    }
}
