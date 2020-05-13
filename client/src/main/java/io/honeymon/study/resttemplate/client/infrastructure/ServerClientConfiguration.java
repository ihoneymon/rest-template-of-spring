package io.honeymon.study.resttemplate.client.infrastructure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HTTP 클라이언트 구현체 선택하기
 */
@Configuration
@ConfigurationPropertiesScan
public class ServerClientConfiguration {

    @Configuration
    @ConditionalOnProperty(name = "client.mode", havingValue = "http-client")
    public static class ServerClientHttpClientConfiguration {
        @Bean
        public ServerClient serverClient(RestTemplateBuilder restTemplateBuilder, ServerClientProperties properties) {
            return new ServerClientHttpClient(restTemplateBuilder, properties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "client.mode", havingValue = "ok-http")
    public static class ServerClientOkHttpConfiguration {
        @Bean
        public ServerClient serverClient(RestTemplateBuilder restTemplateBuilder, ServerClientProperties properties) {
            return new ServerClientOkHttp(restTemplateBuilder, properties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "client.mode", havingValue = "simple-connection")
    public static class ServerClientSimpleConnectionConfiguration {
        @Bean
        public ServerClient serverClient(RestTemplateBuilder restTemplateBuilder, ServerClientProperties properties) {
            return new ServerClientSimpleConnection(restTemplateBuilder, properties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "client.mode", havingValue = "stub")
    public static class ServerClientStubConfiguration {
        @Bean
        public ServerClient serverClient() {
            return new ServerClientStub();
        }
    }
}
