package com.medipol.ECommerceFinal.repository;

import com.medipol.ECommerceFinal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // Bu import'u ekle

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // YENİ EKLENEN METOT: İsimde geçen bir kelimeye göre, büyük/küçük harf duyarsız arama yapar.
    // Bu bir arama algoritmasıdır.
    List<Product> findByNameContainingIgnoreCase(String keyword);

}