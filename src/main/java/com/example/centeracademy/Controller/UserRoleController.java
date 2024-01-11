package com.example.centeracademy.Controller;

import com.example.centeracademy.Entity.AppUser;
import com.example.centeracademy.Entity.UserRole;
import com.example.centeracademy.Services.UserRole.IRoleServices;
import com.example.centeracademy.Services.UserServices.IUserServices;
import com.example.centeracademy.Services.UserServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/usersRoles")
public class UserRoleController {
    private final IRoleServices roleServices;
    @Autowired
    public UserRoleController(IRoleServices roleServices) {
        this.roleServices = roleServices;
    }


    @GetMapping()
    public ResponseEntity<List<UserRole>> getAllUserRole(){
        return  roleServices.findAllUserRole();
    }

    @GetMapping("/get_by_id")
    public ResponseEntity<UserRole>getUserRoleById(@RequestParam Long id){
        return roleServices.findUserRoleById(id);
    }

}
