package com.system_common.rest.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class BuildRestTemplate {

    @Bean
    public RestTemplate restTemplateGeneric(RestTemplateBuilder restTemplateBuilder,
                                            RestTemplateResponseErrorHandler handlerError){
        RestTemplate restTemplate = restTemplateBuilder.connectTimeout(Duration.ofSeconds(2)).build();
        restTemplate.setErrorHandler(handlerError);
        return new RestTemplate();
    }


}
