package com.example.ecommerce.dto.user;

import com.example.ecommerce.entity.User;
import lombok.Data;

@Data
public class CreateUserRequest {
        private User user ;
        private String roleName ;
    }


