package com.woorifisa.kboxwoori.crawling.repository;

import com.woorifisa.kboxwoori.crawling.entity.Schedule;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableRedisRepositories
public interface ScheduleRepository extends CrudRepository<Schedule, String>, PagingAndSortingRepository<Schedule, String> {
}
