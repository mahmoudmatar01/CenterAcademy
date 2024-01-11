package com.example.centeracademy.Services.UserRole;

import com.example.centeracademy.Entity.AppUser;
import com.example.centeracademy.Entity.UserRole;
import com.example.centeracademy.Exceptions.NotFoundCourseException;
import com.example.centeracademy.Repository.RoleRepository;
import com.example.centeracademy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServicesImpl implements IRoleServices{

    final private RoleRepository userRoleRepository ;
    @Autowired
    public RoleServicesImpl(RoleRepository userRoleRepository){
        this.userRoleRepository=userRoleRepository;
    }

    @Override
    public ResponseEntity<List<UserRole>> findAllUserRole() {
        return new ResponseEntity<>(userRoleRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserRole> findUserRoleById(Long id) {
        Optional<UserRole> userRole= this.userRoleRepository.findById(id);
        if(userRole.isEmpty()){
            throw  new NotFoundCourseException("UserRole Not Found");
        }
        return new ResponseEntity<>(userRole.get(),HttpStatus.OK);
    }


}
