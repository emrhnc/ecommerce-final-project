package com.medipol.ECommerceFinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity // Bu sınıfın bir veritabanı tablosu olduğunu belirtir.
@Getter
@Setter
public class Product extends BaseEntity { // BaseEntity'den kalıtım alır.

    private String name;
    private String description;
    private double price;
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY) // İlişki: Birçok Ürün, Bir Kategori'ye aittir.
    private Category category;
}