package com.konblog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.konblog.module.*.mapper")
public class KonblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(KonblogApplication.class, args);
    }
}