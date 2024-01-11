package com.example.centeracademy.Services.UserServices;

import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.AppUser;
import com.example.centeracademy.Entity.CourseEntity;
import com.example.centeracademy.Exceptions.NotFoundCourseException;
import com.example.centeracademy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements IUserServices{

    private  final UserRepository userRepository;
    @Autowired
    public UserServices(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser>userList=userRepository.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AppUser> getUserById(Long id) {
        Optional<AppUser> user= this.userRepository.findById(id);
        if(user.isEmpty()){
            throw  new NotFoundCourseException("User Not Found");
        }
        return new ResponseEntity<>(user.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AppUser> getUserByName(String name) {
        Optional<AppUser> user= this.userRepository.findByUserName(name);
        if(user.isEmpty()){
            throw  new NotFoundCourseException("User Not Found");
        }
        return new ResponseEntity<>(user.get(),HttpStatus.OK);
    }
}
