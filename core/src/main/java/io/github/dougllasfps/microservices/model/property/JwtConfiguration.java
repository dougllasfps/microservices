package io.github.dougllasfps.microservices.model.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt.config")
public class JwtConfiguration {

    private String loginUrl = "/login/**";

    @NestedConfigurationProperty
    private Header header = new Header();

    private int expiration = 3600;

    private String privateKey = "A9x4izorlsvd5Xl627ikupYXWna2ETiZ";
    private String type = "encrypted";

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {
        private String name = "Authorization";
        private String prefix = "Bearer ";
    }
}
