package com.konblog.module.upload.config;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Value("${upload.minio.endpoint:http://localhost:9000}") private String endpoint;
    @Value("${upload.minio.access-key:minioadmin}") private String accessKey;
    @Value("${upload.minio.secret-key:minioadmin}") private String secretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
    }
}