package br.com.boardGameLibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConfigBeans {

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }
}
