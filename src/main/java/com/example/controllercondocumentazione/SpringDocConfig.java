package com.example.controllercondocumentazione;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    static {
        SpringDocUtils.getConfig().addAnnotationsToIgnore(
                org.springframework.web.bind.annotation.RestController.class
        );
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Documentation").version("1.0.0")
                        .termsOfService("https://it.wikipedia.org/wiki/Termini_di_servizio")
                        .description("esercizio sulla documentazione java"
                        ))
                .addTagsItem(new Tag().name("name-controller").description("controller sul nome"));
    }


}