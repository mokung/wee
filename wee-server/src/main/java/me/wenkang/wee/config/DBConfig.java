package me.wenkang.wee.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by wenkang
 * on 2017/9/30.
 */
@SpringBootConfiguration
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

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        DruidDataSource datasource = new DruidDataSource();

        datasource.setDriverClassName(driverClassName);
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);

        datasource.setTimeBetweenConnectErrorMillis(connectionTimeout);
        datasource.setMaxWait(maxLifetime);
        datasource.setValidationQuery(validationQuery);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setName("dataPool");
        return datasource;
    }
}
