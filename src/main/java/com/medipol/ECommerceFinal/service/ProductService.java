package com.medipol.ECommerceFinal.service;

import com.medipol.ECommerceFinal.model.Product;
import com.medipol.ECommerceFinal.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final NotificationService notificationService;

    public ProductService(ProductRepository productRepository, NotificationService notificationService) {
        this.productRepository = productRepository;
        this.notificationService = notificationService;
    }

    public Product saveProduct(Product product) {
        System.out.println(">>> Ürün kaydetme metodu BAŞLADI (Ana Thread)...");
        Product savedProduct = productRepository.save(product);

        // Asenkron metodu çağır. Bu metot anında bir 'CompletableFuture' nesnesi döndürür ve beklemez.
        notificationService.sendProductAddedNotification(savedProduct);

        System.out.println(">>> Ürün kaydetme metodu BİTTİ ve kullanıcıya yanıt döndü (Ana Thread)...");
        return savedProduct;
    }

    // ... Diğer metotlar aynı kalacak ...
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getAllProductsSortedByPrice() {
        return productRepository.findAll(Sort.by("price"));
    }
    public List<Product> searchProductsByName(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
    public List<Product> findProductsMoreExpensiveThan(double minPrice) {
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() > minPrice)
                .collect(Collectors.toList());
    }
}