package com.cursosapi.cursos.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class SpringTimezoneConfig {

    //Após a classe ser inicializada pelo Spring, o método construtor dela
    // é executado e, após isso, o primeiro método a ser executado é este
    @PostConstruct
    public void timezoneConfig() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
