package com.bosonit.esqueleto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Pedro
 */
@SpringBootApplication(scanBasePackages = {
        "com.bosonit.esqueleto.servicios",
        "com.bosonit.esqueleto.repositorios",
        "com.bosonit.esqueleto.REST",
        "com.bosonit.esqueleto.seguridad"})
@EntityScan(basePackages = "com.bosonit.esqueleto.entidades")
public class PruebaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PruebaApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PruebaApplication.class);
    }

}