package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;

import java.util.Optional;

public interface UserService {

    User createUserWithRole(User user, String roleName) ;
    User getUserById(Long id);

    Optional<User> searchUserwithEmailAndRole(String Email, String roleName);

    Boolean checkIfUserExistswithEmailAndRole(User user, String roleName);



}
