package com.jake.blog.repository;

import com.jake.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 자동으로 bean 등록되기 때문에, @Repository 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
