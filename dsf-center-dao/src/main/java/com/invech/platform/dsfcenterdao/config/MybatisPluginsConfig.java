package com.invech.platform.dsfcenterdao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPluginsConfig {

    @Bean
    public MybatisInterceptor MybatisInterceptor(){
        return new MybatisInterceptor();
    }
}
