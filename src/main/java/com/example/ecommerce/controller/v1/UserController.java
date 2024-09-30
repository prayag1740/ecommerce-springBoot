package com.example.ecommerce.controller.v1;

import com.example.ecommerce.config.ApiResponse;
import com.example.ecommerce.dto.user.CreateUserRequest;
import com.example.ecommerce.dto.user.CreateUserResponse;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService ;

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = request.getUser();
        String roleName = request.getRoleName();
        User newUser = userService.createUserWithRole(user, roleName);
        CreateUserResponse userResponse = new CreateUserResponse(newUser, roleName) ;
        ApiResponse<CreateUserResponse> apiResponse = new ApiResponse<>(userResponse) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse) ;
    }

}
