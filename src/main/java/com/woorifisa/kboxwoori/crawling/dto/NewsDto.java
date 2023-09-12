package com.woorifisa.kboxwoori.crawling.dto;

import com.woorifisa.kboxwoori.crawling.entity.News;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NewsDto implements Serializable {
        private String id;
        private String articleLink;
        private String imgLink;
        private String headline;
        private String contentPreview;
        private String date;

        public News toEntity() {
                return News.builder()
                        .id(id)
                        .articleLink(articleLink)
                        .imgLink(imgLink)
                        .headline(headline)
                        .contentPreview(contentPreview)
                        .date(date)
                        .build();
        }
}
