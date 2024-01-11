package com.example.centeracademy.Services.UserServices;

import com.example.centeracademy.Entity.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserServices {

    ResponseEntity<List<AppUser>> getAllUser();
    ResponseEntity<AppUser> getUserById(Long id);
    ResponseEntity<AppUser> getUserByName(String name);
}
