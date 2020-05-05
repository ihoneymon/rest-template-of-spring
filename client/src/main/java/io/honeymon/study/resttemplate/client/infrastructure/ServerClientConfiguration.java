package io.honeymon.study.resttemplate.client.infrastructure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerClientConfiguration {

    @Configuration
    @ConfigurationPropertiesScan
    @ConditionalOnProperty(name = "client.mode", havingValue = "rest")
    public static class ServerClientRestConfiguration {
        @Bean
        public ServerClient serverClient(ServerClientProperties properties) {
            return new ServerClientRest(properties);
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
