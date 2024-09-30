package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;

import java.util.Optional;

public interface UserService {

    User createUserWithRole(User user, String roleName) ;
    User getUserById(Long id);

    Boolean checkIfUserExistswithEmailAndRole(String Email, String roleName);



}
