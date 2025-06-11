package com.medipol.ECommerceFinal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDateTime olusturmaTarihi;

    private LocalDateTime guncellemeTarihi;

    @PrePersist
    protected void onCreate() {
        olusturmaTarihi = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        guncellemeTarihi = LocalDateTime.now();
    }
}