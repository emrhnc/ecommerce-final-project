package com.medipol.ECommerceFinal.service;

import com.medipol.ECommerceFinal.model.Product;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class NotificationService {

    // Metodun bir "gelecek" sonucu döndüreceğini belirtiyoruz.
    // Ayrıca hangi thread havuzunu kullanacağını da açıkça söylüyoruz.
    @Async("taskExecutor")
    public CompletableFuture<String> sendProductAddedNotification(Product product) {
        // Arka planda çalışacak olan görevi CompletableFuture.supplyAsync ile tanımlıyoruz.
        return CompletableFuture.supplyAsync(() -> {
            // Thread'in adını yazdırarak farklı bir thread'de çalıştığını görelim.
            System.out.println(">>> BİLDİRİM GÖNDERİLİYOR (Thread: " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(5000); // 5 saniye bekle
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            String message = "BİLDİRİM GÖNDERİLDİ: Yeni ürün eklendi -> " + product.getName();
            System.out.println(">>> " + message + " (Thread: " + Thread.currentThread().getName() + ")");
            return message;
        });
    }
}