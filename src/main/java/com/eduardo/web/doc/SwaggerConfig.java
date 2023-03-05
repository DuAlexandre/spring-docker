package com.eduardo.web.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact(){

        return new Contact(
                "Eduardo Alexandre",
                "https://github.com/DuAlexandre",
                "luis.edu.alex@gmail.com"
        );
    }

    private ApiInfoBuilder infoApi(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Rest API with Spring");
        apiInfoBuilder.description("Exemplo de API Rest");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de Uso: Open Source");
        apiInfoBuilder.license("Aqui a Licença da Empresa");
        apiInfoBuilder.licenseUrl("site da Licença");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;
    }


    @Bean
    public Docket apiDetails(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eduardo.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infoApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}
