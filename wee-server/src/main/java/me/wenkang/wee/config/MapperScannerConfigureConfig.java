package me.wenkang.wee.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;

/**
 * Created by wenkang
 * on 2017/9/30.
 */
@SpringBootConfiguration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfigureConfig {


    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("me.wenkang.wee.dao");
        return mapperScannerConfigurer;
    }
}
