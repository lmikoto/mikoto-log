package io.github.lmikoto.log;

import io.github.lmikoto.jpa.query.BaseRepositoryFactoryBean;
import io.github.lmikoto.mikoto.event.EnableEventBus;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableEventBus
@ComponentScan(value={"io.github.lmikoto.log"})
@EntityScan(value={"io.github.lmikoto.log"})
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class,basePackages = {"io.github.lmikoto.log"})
public class LogConfig {
}
