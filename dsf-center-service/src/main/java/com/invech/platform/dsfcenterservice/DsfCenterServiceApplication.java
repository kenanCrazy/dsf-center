package com.invech.platform.dsfcenterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
//@MapperScan("com.invech.platform.dsfcenterdao.mapper")
public class DsfCenterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsfCenterServiceApplication.class, args);
    }

}

