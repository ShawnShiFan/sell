package com.shawn.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Shawn
 * @Date: 2019/4/10 16:59
 * @Version 1.0
 */
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8088")  //客户端地址
                        .allowCredentials(true)
                        .allowedMethods("GET","POST","DELETE","PUT","PATCH")
                        .allowedHeaders("*")
                        .maxAge(3600);
            }
        };
    }
}
