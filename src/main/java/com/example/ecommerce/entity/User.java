package com.example.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId ;

    @Size(min=5, max=20, message = "First name must be between 5 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]]*$", message = "First name cannot contain numbers or special characters")
    @Column(name = "first_name")
    private String firstName ;

    @Size(min=5, max=20, message = "Last name must be between 5 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]]*$", message = "Last name cannot contain numbers or special characters")
    @Column(name = "last_name")
    private String lastName ;

    @Size(min = 5 , max = 20, message = "Mobile Number must exactly be 10 digits long")
    @Pattern(regexp = "^[d{10}$]", message = "Mobile number must only contain digits")
    @Column(nullable = false, name = "mobile_number")
    private String mobileNumber ;

    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true, name = "email")
    private String email ;

    @Column(name = "password")
    private String password ;

    @Column(name = "is_active")
    private Boolean isActive = true ;

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

    public User(String firstName, String lastName, String mobileNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
    }
    public User() {
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
