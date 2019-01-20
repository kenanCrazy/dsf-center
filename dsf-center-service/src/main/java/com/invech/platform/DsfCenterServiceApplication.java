package com.invech.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableFeignClients
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class DsfCenterServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DsfCenterServiceApplication.class,args);
  }
}
