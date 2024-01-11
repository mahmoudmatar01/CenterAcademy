package com.example.centeracademy.Services.UserRole;

import com.example.centeracademy.Entity.UserRole;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRoleServices {

    ResponseEntity<List<UserRole>> findAllUserRole();
    ResponseEntity<UserRole>findUserRoleById(Long id);
}
