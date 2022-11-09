package com.jake.blog.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class User {

    @Id //Primary Key가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment 활용
    private Long id;

    @Column(nullable = false,length = 40)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    private Type role;

    @CreationTimestamp
    private Timestamp createDate;
}
