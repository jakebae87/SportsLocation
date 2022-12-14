package com.jake.blog.service;

import com.jake.blog.model.Map;
import com.jake.blog.model.User;
import com.jake.blog.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MapService {

    @Autowired
    private MapRepository mapRepository;

    @Transactional
    public void write(Map map, User user) {
        map.setUser(user);
        mapRepository.save(map);
    }
}
