package com.jake.blog.controller;

import com.jake.blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/board/write")
    public String write() {
        return "/board/write";
    }
}
