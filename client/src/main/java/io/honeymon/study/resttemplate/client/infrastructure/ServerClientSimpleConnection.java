package io.honeymon.study.resttemplate.client.infrastructure;

import org.apache.http.HttpHeaders;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class ServerClientSimpleConnection implements ServerClient {
    private final ServerClientProperties properties;
    private final RestTemplate restTemplate;

    public ServerClientSimpleConnection(RestTemplateBuilder restTemplateBuilder, ServerClientProperties properties) {
        this.properties = properties;

        ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        this.restTemplate = restTemplateBuilder
                .rootUri(properties.getRootUri())
                .requestFactory(() -> requestFactory)
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, properties.getAuthorizationKey())
                .errorHandler(new ServerClientHttpClient.CustomResponseErrorHandler())
                .build();
    }
}
