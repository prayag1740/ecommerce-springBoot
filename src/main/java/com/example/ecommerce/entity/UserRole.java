package com.example.ecommerce.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
public class UserRole {

    public static final int USER_ROLE = 1 ;
    public static final int ADMIN_ROLE = 2 ;
    public static final int MASTER_ROLE = 3 ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @JoinColumn(name = "user_id", nullable = false)
    private User user ;

    @Column(name = "role_id", nullable = false)
    private Integer roleId = USER_ROLE ;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt ;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public UserRole(Long id, User user, Integer roleId, Boolean isActive) {
        this.id = id;
        this.user = user;
        this.roleId = roleId;
        this.isActive = isActive;
    }
    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user=" + user +
                ", roleId=" + roleId +
                '}';
    }
}
