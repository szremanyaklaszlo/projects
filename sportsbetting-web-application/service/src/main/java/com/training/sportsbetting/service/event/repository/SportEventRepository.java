package com.training.sportsbetting.service.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.SportEvent;

@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {

}
