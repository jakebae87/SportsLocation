package com.jake.blog.controller;

import com.jake.blog.config.auth.PrincipalDetail;
import com.jake.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("boards",boardService.list());
        return "index";
    }

    @GetMapping("/board/write")
    public String write() {
        return "/board/write";
    }
}
