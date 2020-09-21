package com.psx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties
@ServletComponentScan
@EnableOpenApi
@MapperScan("com.psx.mapper")
public class IqiyiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IqiyiApplication.class, args);
    }

}
