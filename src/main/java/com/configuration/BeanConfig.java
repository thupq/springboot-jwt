package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
@EnableAspectJAutoProxy
public class BeanConfig {
    @Bean(value = "fixedTaskExecutor")
    public Executor initFixedTaskExecutor() {
        return Executors.newFixedThreadPool(5);
    }
}
