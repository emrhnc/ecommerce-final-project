package com.medipol.ECommerceFinal.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity // Bu sınıfın bir veritabanı tablosu olduğunu belirtir.
@Getter
@Setter
public class Category extends BaseEntity { // BaseEntity'den kalıtım alır.

    private String name;

}