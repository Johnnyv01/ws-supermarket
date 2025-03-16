package br.supermerkat.supermerkat.infrastructure.config;

import br.supermerkat.supermerkat.application.usescases.ProdutosServiceImp;
import br.supermerkat.supermerkat.domain.ports.outbound.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configurations implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
    }

    @Bean
    public ProdutosServiceImp produtosServiceImp(ProductRepositoryPort productRepositoryPort) {
        return new ProdutosServiceImp(productRepositoryPort);
    }
}
