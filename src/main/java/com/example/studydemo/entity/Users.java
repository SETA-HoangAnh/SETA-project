package com.example.studydemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String userAddress;

}
