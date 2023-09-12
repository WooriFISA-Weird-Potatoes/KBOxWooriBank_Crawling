package com.woorifisa.kboxwoori.crawling.repository;

import com.woorifisa.kboxwoori.crawling.entity.News;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableRedisRepositories
public interface NewsRepository extends CrudRepository<News, String>, PagingAndSortingRepository<News, String> {
}
