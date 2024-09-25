package com.example.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category ; ;

    @Column(name = "name", nullable = false)
    private String name ;

    @Column(name = "description")
    private String description ;

    @Column(name = "price", nullable = false)
    private Double price ;

    @ManyToOne
    @JoinColumn(name = "added_by", nullable = false)
    private User addedBy ;
    @Column(name = "is_active", nullable = false)
    private boolean isActive = true ;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt ;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now() ;
        updatedAt = LocalDateTime.now() ;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Product() {}

    public Product(Long id, Category category, String name, String description, Double price, User addedBy, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.addedBy = addedBy;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


}
