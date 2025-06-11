package com.medipol.ECommerceFinal.repository;

import com.medipol.ECommerceFinal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository<Category, Long> -> Generic kullanımı: Category entity'si ile çalış, ID'si Long tipindedir.
public interface CategoryRepository extends JpaRepository<Category, Long> {

}