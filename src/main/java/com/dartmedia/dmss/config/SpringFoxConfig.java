package com.dartmedia.dmss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SWAGGER2 설정
 * 스웨거는 API를 문서화하여 쉽게 확인할수 있게 해줌
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {              
                          
    @Bean
    public Docket swaggerApi() {
      return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(swaggerInfo()).select()
          .apis(RequestHandlerSelectors.basePackage("com.dartmedia.dmss.controller")) // API 컨트롤러 위치 설정
          .paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
    }
  
    /**
     * 추가 설정으로 문서화를 커스터마이징 할 수 있음
     */
    private ApiInfo swaggerInfo() {
      return new ApiInfoBuilder().title("Easy Pay Management Service API Documentation").description("Only For Gaji")
          .license("DartDev").licenseUrl("https://dartmeda.co.kr/").version("1").build();
    } 
}