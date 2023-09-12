package com.woorifisa.kboxwoori.crawling.repository;

import com.woorifisa.kboxwoori.crawling.entity.Rankings;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableRedisRepositories
public interface RankingsRepository extends CrudRepository<Rankings, String>, PagingAndSortingRepository<Rankings, String> {
}
