package com.konblog.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI konblogOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("KonBlog API").description("KonBlog 接口文档").version("v1.0.0").contact(new Contact().name("KonBlog")));
    }
}