package com.example.ecommerce.dto.user;

import com.example.ecommerce.entity.User;
import lombok.Data;

@Data
public class CreateUserResponse extends UserGenericResponse {

    private String roleName ;

    public CreateUserResponse(User user, String roleName) {
        super(user);
        this.roleName = roleName ;
    }

}





