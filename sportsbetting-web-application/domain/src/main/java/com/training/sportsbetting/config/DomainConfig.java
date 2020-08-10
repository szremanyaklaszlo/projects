package com.training.sportsbetting.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.training.sportsbetting")
public class DomainConfig {

}
