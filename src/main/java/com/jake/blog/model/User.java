package com.jake.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id //Primary Key가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment 활용
    private int id;

    @Column(nullable = false,length = 40, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Type role;

    @CreationTimestamp
    private Timestamp createDate;
}
