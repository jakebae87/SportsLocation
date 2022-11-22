package com.jake.blog.controller.api;

import com.jake.blog.service.TournamentService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/tournament")
    public String tournament(Model model) throws IOException {
        Document page = tournamentService.crawling();
        model.addAttribute("page",page);
        return "/tournament/page";
    }
}
