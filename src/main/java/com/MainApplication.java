package com;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class MainApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    public Docket swaggerConfiguration() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {

        return new ApiInfo(
                "Cab Api",
                "Application in JAVA",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Kanza Jamal", "https://github.com/skanzajamal", "k122060@nu.ed.pk"),
                "API License",
                "https://github.com/skanzajamal",
                Collections.emptyList());
    }

} //ENDCLASS