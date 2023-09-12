package com.woorifisa.kboxwoori.crawling.service;

import com.woorifisa.kboxwoori.crawling.entity.News;
import com.woorifisa.kboxwoori.crawling.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsCrawlingService {

    private final NewsRepository newsRepository;

    public void crawlKboNews() {
        try {
            Document document = Jsoup.connect("https://www.koreabaseball.com/News/BreakingNews/List.aspx").get();
            Element boardPhoto = document.select("ul.boardPhoto").first();
            Elements listItems = boardPhoto.select("li");

            for (int index = 0; index < listItems.size(); index++) {
                String articleLink = null;
                String imgLink = null;
                String headline = null;
                String contentPreview = null;
                String date = null;
                Element listItem = listItems.get(index);
                articleLink = listItem.select("span.photo a").attr("href");
                imgLink = listItem.select("span.photo img").attr("src");
                headline = listItem.select("div.txt strong a").text();
                contentPreview = listItem.select("div.txt p").first().ownText();
                date = listItem.select("div.txt p span.date").text();

                News saveNews = newsRepository.save(News.builder()
                                                        .id(LocalDate.now() + "-" + String.format("%03d", index + 1))
                                                        .articleLink("https://www.koreabaseball.com/News/BreakingNews/" + articleLink)
                                                        .imgLink("https:" + imgLink)
                                                        .headline(headline)
                                                        .contentPreview(contentPreview)
                                                        .date(date)
                                                        .build());
            }
            log.info("뉴스 데이터 크롤링 완료");
        } catch (Exception e) {
            log.error("뉴스 데이터 크롤링 예외 발생: {}", e.getMessage());
        }
    }
}
