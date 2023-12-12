package br.supermerkat.supermerkat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/products")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST");  // Adicione métodos permitidos conforme necessário
    }
}
