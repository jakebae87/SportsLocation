package com.jake.blog.controller;

import com.jake.blog.config.auth.PrincipalDetail;
import com.jake.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.list(pageable));
        return "/board/list";
    }

    @GetMapping("/board/write")
    public String write() {
        return "/board/write";
    }


    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("board",boardService.detail(id));
        return "/board/detail";
    }

    @GetMapping("/board/{id}/update")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("board", boardService.detail(id));
        return "/board/update";
    }
}
