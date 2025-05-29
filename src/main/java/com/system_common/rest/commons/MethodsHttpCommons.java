package com.system_common.rest.commons;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@Component
public class MethodsHttpCommons {
    private final RestTemplate restTemplate;

    public MethodsHttpCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <I,O> ResponseEntity<O> postForEntity(String url, I request, Class<O> classType,HttpHeaders headers){
        headers = headers == null ? new HttpHeaders(): headers;
        HttpEntity<I> requestEntity = new HttpEntity<>(request, headers);
        headers.add("request-id", UUID.randomUUID().toString());
        return restTemplate.postForEntity(url,requestEntity,classType);
    }
}
