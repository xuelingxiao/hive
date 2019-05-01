package com.xlx.product.repository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MultiDataSourceConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public DataSource getDynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object,Object> map = new HashMap<>();

        for (int i = 1; i < 3 ; i++) {
            String name = environment.getProperty("spring.ds"+String.valueOf(i)+".name");
            if (name==null) break;
            DataSource dataSource = DataSourceBuilder.create()
                    .driverClassName(environment.getProperty("spring.ds"+String.valueOf(i)+".driver-class-name"))
                    .username(environment.getProperty("spring.ds"+String.valueOf(i)+".username"))
                    .url(environment.getProperty("spring.ds"+String.valueOf(i)+".url"))
                    .password(environment.getProperty("spring.ds"+String.valueOf(i)+".password"))
                    .build();
            if (name.trim().toUpperCase().equals("MASTER")){
                dynamicDataSource.setDefaultTargetDataSource(dataSource);
                map.put(DBType.MASTER,dataSource);
            }else{
                map.put(DBType.SLAVE,dataSource);
            }
        }

        dynamicDataSource.setTargetDataSources(map);
        return dynamicDataSource;
    }


}
