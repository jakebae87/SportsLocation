package com.jake.blog.controller;

import com.jake.blog.dto.GameDto;
import com.jake.blog.service.GameService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public String tournament(Model model) throws IOException {
        List<GameDto> gameList = gameService.list();
        model.addAttribute("gameList",gameList);
        return "/game/game";
    }
}
