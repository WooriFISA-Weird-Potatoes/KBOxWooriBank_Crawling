package com.woorifisa.kboxwoori.crawling.repository;

import com.woorifisa.kboxwoori.crawling.entity.TodaySchedule;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

@EnableRedisRepositories
public interface TodayScheduleRepository extends CrudRepository<TodaySchedule, String>, PagingAndSortingRepository<TodaySchedule, String> {
    List<TodaySchedule> findByDate(LocalDate date);
}
