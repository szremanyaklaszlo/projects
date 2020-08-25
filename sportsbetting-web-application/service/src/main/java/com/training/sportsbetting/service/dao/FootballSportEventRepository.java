package com.training.sportsbetting.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.FootballSportEvent;

@Repository
public interface FootballSportEventRepository extends JpaRepository<FootballSportEvent, Long> {

    FootballSportEvent findByTitle(String title);

}
