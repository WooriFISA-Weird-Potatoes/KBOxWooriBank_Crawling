package com.woorifisa.kboxwoori.crawling.scheduler;

import com.woorifisa.kboxwoori.crawling.service.NewsCrawlingService;
import com.woorifisa.kboxwoori.crawling.service.RankingsCrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyDataCrawler {

    private final NewsCrawlingService newsCrawlingService;
    private final RankingsCrawlingService rankingsCrawlingService;

    @Scheduled(cron = "0 0 0 * * *")
    void newsCrawler() {
        newsCrawlingService.crawlKboNews();
    }


    @Scheduled(cron = "0 0 0 * * *")
    void rankingCrawler() {
        rankingsCrawlingService.crawlKboRanking();
    }
}
