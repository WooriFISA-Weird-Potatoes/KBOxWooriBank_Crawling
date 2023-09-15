package com.woorifisa.kboxwoori.crawling.service;

import com.woorifisa.kboxwoori.crawling.entity.Rankings;
import com.woorifisa.kboxwoori.crawling.entity.TeamLogo;
import com.woorifisa.kboxwoori.crawling.repository.RankingsRepository;
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
public class RankingsCrawlingService {

    private final RankingsRepository rankingsRepository;

    public void crawlKboRanking() {
        try {
            Document document = Jsoup.connect("https://www.koreabaseball.com/Record/TeamRank/TeamRank.aspx").get();
            Element table = document.select("table.tData").first();
            if (table == null) {
                throw new Exception("대상 웹페이지에 크롤링할 수 있는 내용이 없습니다.");
            }

            Elements rows = table.select("tr");

            int index = 0;

            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cells = row.select("td");

                rankingsRepository.save(Rankings.builder()
                                                .id(LocalDate.now() + "-" + index)
                                                .rank(cells.get(0).text())
                                                .teamName(cells.get(1).text())
                                                .teamLogo(TeamLogo.fromString(cells.get(1).text()).getTeamLogoUrl())
                                                .gamesPlayed(cells.get(2).text())
                                                .wins(cells.get(3).text())
                                                .losses(cells.get(4).text())
                                                .draws(cells.get(5).text())
                                                .winningPercentage(cells.get(6).text())
                                                .gameBehind(cells.get(7).text())
                                                .build());
                index++;
            }
            log.info("순위 데이터 크롤링 완료");
        } catch (Exception e) {
            log.error("순위 데이터 크롤링 예외 발생: {}", e.getMessage());
        }
    }

}

