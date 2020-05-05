package io.honeymon.study.resttemplate.client.infrastructure;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.time.Duration;

@Getter
@ConfigurationProperties(prefix = "server")
public class ServerClientProperties {
    private String rootUri;
    private String authorizationKey;
    private Duration connectTimeout;
    private Duration readTimeout;
    private int maxConnectPerRoute;
    private int maxConnectCount;

    @ConstructorBinding
    public ServerClientProperties(
            String rootUri
            , String authorizationKey
            , Duration connectTimeout
            , Duration readTimeout
            , int maxConnectPerRoute
            , int maxConnectCount) {

        this.rootUri = rootUri;
        this.authorizationKey = authorizationKey;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.maxConnectPerRoute = maxConnectPerRoute;
        this.maxConnectCount = maxConnectCount;
    }
}
