package com.woorifisa.kboxwoori.crawling.entity;

import com.woorifisa.kboxwoori.crawling.dto.TodayScheduleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@RedisHash(value = "crawling:todaySchedule", timeToLive = 259200)
public class TodaySchedule {
    @Id
    private String id;
    @Indexed
    private LocalDate date;
    @Indexed
    private String gameTime;
    private String team1Name;
    private String team1Logo;
    private String team1Score;
    private String team1SPState;
    private String team1SPLink;
    private String team1SPName;
    private String team2Name;
    private String team2Logo;
    private String team2Score;
    private String team2SPState;
    private String team2SPLink;
    private String team2SPName;

    @Builder
    public TodaySchedule(String id, LocalDate date, String gameTime, String team1Name, String team1Logo, String team1Score, String team1SPState, String team1SPLink, String team1SPName, String team2Name, String team2Logo, String team2Score, String team2SPState, String team2SPLink, String team2SPName) {
        this.id = id;
        this.date = date;
        this.gameTime = gameTime;
        this.team1Name = team1Name;
        this.team1Logo = team1Logo;
        this.team1Score = team1Score;
        this.team1SPState = team1SPState;
        this.team1SPLink = team1SPLink;
        this.team1SPName = team1SPName;
        this.team2Name = team2Name;
        this.team2Logo = team2Logo;
        this.team2Score = team2Score;
        this.team2SPState = team2SPState;
        this.team2SPLink = team2SPLink;
        this.team2SPName = team2SPName;
    }
    public TodayScheduleDto toResponseDTO() {
        return TodayScheduleDto.builder()
                               .id(this.id)
                               .date(this.date)
                               .gameTime(this.gameTime)
                               .team1Name(this.team1Name)
                               .team1Logo(this.team1Logo)
                               .team1Score(this.team1Score)
                               .team1SPState(this.team1SPState)
                               .team1SPLink(this.team1SPLink)
                               .team1SPName(this.team1SPName)
                               .team2Name(this.team2Name)
                               .team2Logo(this.team2Logo)
                               .team2Score(this.team2Score)
                               .team2SPState(this.team2SPState)
                               .team2SPLink(this.team2SPLink)
                               .team2SPName(this.team2SPName)
                               .build();
    }
}

