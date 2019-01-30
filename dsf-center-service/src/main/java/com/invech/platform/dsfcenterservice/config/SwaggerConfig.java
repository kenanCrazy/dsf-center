package com.invech.platform.dsfcenterservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger UI 配置
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

    @Value("${swagger.scope: com.invech.platform.dsfcenterservice}")
    private String basePackage;

    @Value("${swagger.profile}")
    private String profile;

    @Bean
    public Docket buildDocket() {
        if(this.profile.equals("dev") || this.profile.equals("test")){
            return new Docket(DocumentationType.SWAGGER_2).enable(true)
                    .groupName(profile)
                    .apiInfo(buildApiInf())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(basePackage))//要扫描的API(Controller)基础包
                    .paths(PathSelectors.any())
                    .build();
        }
        return new Docket(DocumentationType.SWAGGER_2).enable(false)
                .groupName(profile)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))//要扫描的API(Controller)基础包
                .paths(PathSelectors.any())
                .build();

    }

    //com.eveb.saasops.api.modules.user

    /*
     public Docket buildDocket() {
     return new Docket(DocumentationType.SWAGGER_2)
              .groupName("dev")
          .apiInfo(buildApiInf())
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.eveb.saasops.api.modules"))//要扫描的API(Controller)基础包
          .paths(PathSelectors.any())
          .build();
    }*/
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("invech dsf-center-service API文档")
                .contact("invech")
                .version("1.0")
                .build();
    }
}
