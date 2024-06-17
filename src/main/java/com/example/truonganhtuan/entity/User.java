package com.example.truonganhtuan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data

@Entity
@Table(name = "user")
public class User {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password", length = 250,nullable = false)

    private String password;
    @Column(name = "email",length = 50)

    private String email;
    @Column(name = "name",length = 50, nullable = false)

    private String name;
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role>roles=new HashSet<>();



    @Column(name = "provider")
    private String provider;

}
