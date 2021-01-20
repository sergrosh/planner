package com.familyplanner.planner.config;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
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
@ConditionalOnWebApplication
public class SwaggerConfig {
    /**
     * Create the Swagger Docket for Planner.
     *
     * @return the docket
     */
    @Bean
    public Docket krakenApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("planner-service")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
        return docket.select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build();
    }

    private ApiInfo apiInfo() {
        final Contact contact = new Contact("Planner application team", "", "");
        return new ApiInfoBuilder()
                .title("Planner REST service API")
                .description("Planner - the best application for family budget planning")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
