package com.system_common.rest.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.system_common.rest.dto.ResponseGeneric;
import com.system_common.rest.exception.RestApiServerException;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private final JsonMapper jsonMapper = new JsonMapper();

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError();
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        String responseText = response.getStatusText();
        ResponseGeneric<Object> responseGeneric = jsonMapper.readValue(responseText.getBytes(), ResponseGeneric.class);
        String message = "error response client in "+url.getPath();
        throw new RestApiServerException(message,responseGeneric);
    }

}
