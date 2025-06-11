package com.medipol.ECommerceFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration // Bu sınıfın bir yapılandırma sınıfı olduğunu belirtir.
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // Başlangıçta havuzda olacak thread sayısı
        executor.setMaxPoolSize(5);  // Havuzun ulaşabileceği maksimum thread sayısı
        executor.setQueueCapacity(500); // İşlemlerin bekleyeceği sıra kapasitesi
        executor.setThreadNamePrefix("Async-"); // Thread'lere verilecek ön ek
        executor.initialize();
        return executor;
    }
}