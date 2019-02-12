package com.invech.platform.dsfcenterdao.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import java.util.Map;
import javax.sql.DataSource;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置数据源
 */
@Configuration
@Data
public class DynamicDataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfig.class);
    Map<String, DataSource> targetDataSources ;

    @Bean
    @ConfigurationProperties("spring.datasource.druid.manage")
    public DataSource manageDaraSource(){
        return DruidDataSourceBuilder.create().build();
    }

}
