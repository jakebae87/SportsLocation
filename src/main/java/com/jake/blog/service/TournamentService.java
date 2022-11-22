package com.jake.blog.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TournamentService {
    final String URL = "https://www.koreabasketball.or.kr/game/dom_schedule.php";

    public Document crawling() throws IOException {
        Connection conn = Jsoup.connect(URL);
        Document html = conn.get();

        return html;
    }
}
