package com.medipol.ECommerceFinal.controller;

import com.medipol.ECommerceFinal.model.Product;
import com.medipol.ECommerceFinal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Bu sınıfın bir REST API controller'ı olduğunu belirtir.
@RequestMapping("/api/products") // Bu sınıftaki tüm metotların URL'leri /api/products ile başlar.
public class ProductController {

    @Autowired
    private ProductService productService;

    // Bütün ürünleri getiren endpoint.
    // URL: GET http://localhost:8080/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Yeni bir ürün oluşturan endpoint.
    // URL: POST http://localhost:8080/api/products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Ürünleri fiyata göre sıralı getiren endpoint.
    // URL: GET http://localhost:8080/api/products/sorted-by-price
    @GetMapping("/sorted-by-price")
    public List<Product> getAllProductsSortedByPrice() {
        return productService.getAllProductsSortedByPrice();
    }

    // İsimde arama yapan endpoint.
    // URL: GET http://localhost:8080/api/products/search?keyword=laptop
    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String keyword) {
        return productService.searchProductsByName(keyword);
    }

    // Belirtilen fiyattan daha pahalı ürünleri filtreleyen endpoint.
    // URL: GET http://localhost:8080/api/products/filter/expensive-than?price=500
    @GetMapping("/filter/expensive-than")
    public List<Product> getProductsMoreExpensiveThan(@RequestParam double price) {
        return productService.findProductsMoreExpensiveThan(price);
    }
}