package com.cursosapi.cursos.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoSpringDoc {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("CURSOS API")
                                .description("API para gestão cursos e micro-serviços ")
                                .version("v1")
                                .contact(new Contact().name("João Pedro Golenia").email("joao.golenia.pb@compasso.com.br"))

                );
    }

}
