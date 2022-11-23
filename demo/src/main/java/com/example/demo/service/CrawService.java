package com.example.demo.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class CrawService {

	final String URL = "https://www.koreabasketball.or.kr/game/dom_schedule.php";
	Connection conn = Jsoup.connect(URL);

	@PostConstruct
	public void getKoreaCovidDatas() throws IOException {

		Document doc = Jsoup.connect(URL).get();
		System.out.println(doc);
	}
}
