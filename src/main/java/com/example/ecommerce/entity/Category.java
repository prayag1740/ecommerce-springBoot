package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@ToString
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description ;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true ;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt ;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now() ;
        updatedAt = LocalDateTime.now();
        processName();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
        processName();
    }


    protected void processName() {
        if (name != null) {
            name = name.toUpperCase() ;
        }
    }

    public Category() {
    }

    public Category(Long id, String name, String description, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }

}
