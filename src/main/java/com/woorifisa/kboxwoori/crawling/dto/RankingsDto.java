package com.woorifisa.kboxwoori.crawling.dto;

import com.woorifisa.kboxwoori.crawling.entity.Rankings;
import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RankingsDto implements Serializable {
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

    public Rankings toEntity() {
        return Rankings.builder()
                .id(id)
                .rank(rank)
                .teamName(teamName)
                .teamLogo(teamLogo)
                .gamesPlayed(gamesPlayed)
                .wins(wins)
                .losses(losses)
                .draws(draws)
                .winningPercentage(winningPercentage)
                .gameBehind(gameBehind)
                .build();
    }
}
