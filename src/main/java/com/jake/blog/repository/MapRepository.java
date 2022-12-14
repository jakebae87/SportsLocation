package com.jake.blog.repository;

import com.jake.blog.model.Map;
import org.springframework.data.jpa.repository.JpaRepository;

// 자동으로 bean 등록되기 때문에, @Repository 생략 가능하다.
public interface MapRepository extends JpaRepository<Map, Integer> {
}
