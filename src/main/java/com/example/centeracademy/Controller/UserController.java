package com.example.centeracademy.Controller;

import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.AppUser;
import com.example.centeracademy.Repository.UserRepository;
import com.example.centeracademy.Services.CourseServies.CourseServicesImpl;
import com.example.centeracademy.Services.CourseServies.ICourseServices;
import com.example.centeracademy.Services.UserServices.IUserServices;
import com.example.centeracademy.Services.UserServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {

    private final IUserServices userServices;
    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @GetMapping()
    public ResponseEntity<List<AppUser>> getAllUser(){
        return  userServices.getAllUser();
    }

    @GetMapping("/get_by_id")
    public ResponseEntity<AppUser>getUserById(@RequestParam Long id){
        return userServices.getUserById(id);
    }
 @GetMapping("/get_by_name")
    public ResponseEntity<AppUser>getUserByName(@RequestParam String name){
        return userServices.getUserByName(name);
    }

}
