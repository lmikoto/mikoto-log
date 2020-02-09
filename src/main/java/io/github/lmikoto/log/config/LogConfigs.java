package io.github.lmikoto.log.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@ConfigurationProperties(prefix = "mikoto.log")
public class LogConfigs implements Serializable {

    private Boolean dbEnable = Boolean.TRUE;

}
