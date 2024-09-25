package com.example.ecommerce.service;

import com.example.ecommerce.constants.ErrorConstants;
import com.example.ecommerce.dao.ErrorInfo;
import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.dao.UserRoleRepository;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.entity.UserRole;
import com.example.ecommerce.exception.CustomException;
import com.example.ecommerce.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service //autmatically intializes the service instance
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private UserRoleRepository userRoleRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder ;

    @Override
    @Transactional
    public User createUserWithRole(User user, String roleName) {
        //check if user with roleName already exists
        Optional<User> alreadyExists = searchUserwithEmailAndRole(user.getEmail(), roleName);

        if (alreadyExists != null) {
            ErrorInfo err = ErrorConstants.USER_ROLE_ALREADY_EXISTS;
            throw new CustomException(HttpStatus.NOT_FOUND, err.getStatusCode(), err.getErrorMessage());
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        User newUser = userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setUser(newUser);
        userRole.setRoleId(UserRole.getRoleId(roleName));
        userRoleRepository.save(userRole);
        return newUser ;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Optional<User> searchUserwithEmailAndRole(String email, String roleName) {
        roleName = roleName.toLowerCase();
        int roleId = UserRole.getRoleId(roleName);
        Optional<User> user = userRepository.findByEmail(email) ;

        // throw error if user does not exist
        if (user == null) {
            ErrorInfo err = ErrorConstants.USER_NOT_FOUND;
            throw new CustomException(HttpStatus.NOT_FOUND, err.getStatusCode(), err.getErrorMessage());
        }

        List<UserRole> userRoles = userRoleRepository.findByUser(user) ;

        for (UserRole ur : userRoles) {
            if (ur.getRoleId() == roleId) {
                ErrorInfo err = ErrorConstants.USER_ROLE_ALREADY_EXISTS ;
                throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, err.getStatusCode(), err.getErrorMessage());
            }
        }
        return user ;
    }

    @Override
    public Boolean checkIfUserExistswithEmailAndRole(User user, String roleName) {
        return null;
    }
}
