package com.akuna.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class AkunaCoreApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(AkunaCoreApplication.class);
    }

    @Bean
    public Docket swaggerSettings()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.akuna.core.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    public ApiInfo apiInfo()
    {
        return new ApiInfo(
                "AKUNA Core",
                "https://github.com/akuna-inc-ms/akuna-core.git",
                "0.1",
                "",
                new Contact("AKUNA Team", "", "akuna.inc.ms@gmail.com"),
                "",
                "",
                Collections.emptyList());
    }

    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addRedirectViewController("/", "swagger-ui.html");
    }

}
