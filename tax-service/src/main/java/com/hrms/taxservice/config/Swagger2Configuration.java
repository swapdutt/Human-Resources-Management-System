package com.hrms.taxservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Bean
    public Docket productApi () {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hrms.taxservice.controller"))
                .build().apiInfo(metaData());
    }

    private ApiInfo metaData () {
        return new ApiInfoBuilder()
                .description("Tax Service REST API")
                .title("Tax Service REST API")
                .version("1.0")
                .termsOfServiceUrl("Terms of Service")
                .contact(new Contact("Swapnadeep Dutta", "", "swapdutt1994@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
