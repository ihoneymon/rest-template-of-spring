package io.honeymon.study.resttemplate.client.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ServerClientHttpClient implements ServerClient {
    private final ServerClientProperties properties;
    private final RestTemplate restTemplate;

    public ServerClientHttpClient(RestTemplateBuilder restTemplateBuilder, ServerClientProperties properties) {
        this.properties = properties;

        /**
         * @see <a href="https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClientBuilder.html">HttpClientBuilder</a>
         */
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnPerRoute(properties.getMaxConnectPerRoute()) // 라우트별 커텍션 최대갯수
                .setMaxConnTotal(properties.getMaxConnectCount()) // 전체 커넥션 최대 갯수
                .setConnectionTimeToLive(5, TimeUnit.SECONDS)
                .build(); // 기본 HttpClientConnectionManager PoolingHttpClientConnectionManager 사용

        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory(httpClient);

        this.restTemplate = restTemplateBuilder
                .rootUri(properties.getRootUri())
                .requestFactory(() -> requestFactory)
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, properties.getAuthorizationKey())
                .errorHandler(new CustomResponseErrorHandler())
                .build();
    }

    @Slf4j
    public static class CustomResponseErrorHandler extends DefaultResponseErrorHandler {
        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            log.error("Has error response: {}", response);
            super.handleError(response);
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            log.error("Has error response: {}", response);
            return super.hasError(response);
        }
    }
}
