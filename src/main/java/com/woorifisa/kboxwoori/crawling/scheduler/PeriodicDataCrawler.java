package com.woorifisa.kboxwoori.crawling.scheduler;

import com.woorifisa.kboxwoori.crawling.service.ScheduleCrawlingService;
import com.woorifisa.kboxwoori.crawling.service.TodayScheduleCrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PeriodicDataCrawler {

    private final ScheduleCrawlingService scheduleCrawlingService;
    private final TodayScheduleCrawlingService todayScheduleCrawlingService;

    @Scheduled(cron = "0 0/10 * * * *")
    void scheduleCrawler() {
        scheduleCrawlingService.crawlKboSchedule();
    }

    @Scheduled(cron = "0 0/10 * * * *")
    void todayScheduleCrawler() {
        todayScheduleCrawlingService.crawlKboTodaySchedule();
    }

    @Scheduled(cron = "1 0,30 * * * *")
    void todayMatchCountCrawler() {
        todayScheduleCrawlingService.saveTodayMatchCount();
    }

    @Scheduled(cron = "1 0,30 * * * *")
    void earliestMatchCrawler() {
        todayScheduleCrawlingService.saveEarliestMatch();
    }
}
