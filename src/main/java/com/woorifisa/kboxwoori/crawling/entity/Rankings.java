package com.woorifisa.kboxwoori.crawling.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@ToString
@NoArgsConstructor
@RedisHash(value = "crawling:rankings", timeToLive = 259200)
public class Rankings {
    @Id
    private String id;
    private String rank;
    private String teamName;
    private String teamLogo;
    private String gamesPlayed;
    private String wins;
    private String losses;
    private String draws;
    private String winningPercentage;
    private String gameBehind;

    @Builder
    public Rankings(String id, String rank, String teamName, String teamLogo, String gamesPlayed, String wins, String losses, String draws, String winningPercentage, String gameBehind) {
        this.id = id;
        this.rank = rank;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.winningPercentage = winningPercentage;
        this.gameBehind = gameBehind;
    }
}
