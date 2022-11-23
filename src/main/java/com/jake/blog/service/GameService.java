package com.jake.blog.service;

import com.jake.blog.dto.GameDto;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    final String URL = "https://www.koreabasketball.or.kr/game/dom_schedule.php";

    public List<GameDto> list() throws IOException {
        List<GameDto> gameList = new ArrayList<>();

        Document document = Jsoup.connect(URL).get();
        Elements elements = document.select("table tbody tr");

        for (Element element : elements) {
            Elements contents = element.select("td");
            Elements period = element.select("br");
            Elements ahref = contents.select("a.btn_detail");

            GameDto gameDto = GameDto.builder()
                    .number(contents.get(0).text())
                    .status(contents.get(1).text())
                    .type(contents.get(2).text())
                    .title(contents.get(3).text())
                    .period(contents.get(4).text())
                    .detail(ahref.get(0).attr("abs:href"))
                    .build();

            gameList.add(gameDto);
        }
        return gameList;
    }
}
