package com.invech.platform.dsfcenterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.invech.platform.dsfcenterservice","com.invech.platform.dsfcenterdao"})
@MapperScan(basePackages = {"com.invech.platform.dsfcenterdao.dao","com.invech.platform.dsfcenterdao.mapper"})
public class DsfCenterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsfCenterServiceApplication.class, args);
    }

}

