package com.example.ecommerce.dto.user;

import com.example.ecommerce.entity.User;
import lombok.Data;

@Data
public class UserGenericResponse {
    private Long userId;
    private String firstName ;
    private String lastName ;
    private String mobileNumber ;
    private String email ;

    public UserGenericResponse(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.mobileNumber = user.getMobileNumber();
        this.email = user.getEmail();
    }

}
