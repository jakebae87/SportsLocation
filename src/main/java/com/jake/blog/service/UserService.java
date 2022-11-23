package com.jake.blog.service;

import com.jake.blog.model.Type;
import com.jake.blog.model.User;
import com.jake.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional
    public void join(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encode.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(Type.USER);
        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        User persistence = userRepository.findById(user.getId())
                .orElseThrow(() -> {
                    return new IllegalArgumentException("해당 유저는 없습니다.");
                });
        String rawPassword = user.getPassword();
        String encPassword = encode.encode(rawPassword);
        persistence.setPassword(encPassword);
        persistence.setEmail(user.getEmail());
    }
}
