package com.jake.blog.controller;

import com.jake.blog.model.User;
import com.jake.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 사용자는 없습니다.");
        });
        return user;
    }

    @Transactional
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User theUser = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        theUser.setPassword(user.getPassword());
        theUser.setEmail(user.getEmail());

        return theUser;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 사용자는 없습니다.");
        });

        userRepository.delete(user);
        return "삭제 되었습니다.";
    }

    @GetMapping("/userList")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @PostMapping("/join")
    public String join(User user) {
        userRepository.save(user);
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());
        return "home";
    }
}
