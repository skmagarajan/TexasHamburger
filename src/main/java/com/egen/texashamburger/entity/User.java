package com.egen.texashamburger.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int userId;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private String createdAt;

    public User(){
        this.createdAt = String.valueOf(LocalDateTime.now());
    }
}
