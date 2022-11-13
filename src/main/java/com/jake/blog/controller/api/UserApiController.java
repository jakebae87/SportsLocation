package com.jake.blog.controller.api;

import com.jake.blog.dto.ResponseDto;
import com.jake.blog.model.Type;
import com.jake.blog.model.User;
import com.jake.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        user.setRole(Type.USER);
        int result = userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK, result);
    }

}