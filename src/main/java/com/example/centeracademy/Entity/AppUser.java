package com.example.centeracademy.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sec_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String fullName;
    private String userName;
    private String password;
    @ManyToMany
    @JoinTable(name = "sec_user_roles",joinColumns=@JoinColumn(name ="user_Id" ),
    inverseJoinColumns = @JoinColumn(name = "role_Id"))
    @OrderColumn(name = "id")

    private Set<UserRole> roles=new HashSet<>();
}
