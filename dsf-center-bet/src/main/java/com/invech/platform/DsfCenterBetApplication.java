package com.invech.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DsfCenterBetApplication {

  public static void main(String[] args) {
    SpringApplication.run(DsfCenterBetApplication.class,args);
  }

}
