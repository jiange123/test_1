package com.icarbonx.web.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
public class ApplicationSwaggerConfig {
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class,
                        String.class)
                .securitySchemes(apiKey());

    }
    private List<ApiKey>  apiKey() {
        List<ApiKey> result = new ArrayList<ApiKey>();
        result.add(new ApiKey("mykey", "api_key", "icarbonx"));
        return result;
    }
}