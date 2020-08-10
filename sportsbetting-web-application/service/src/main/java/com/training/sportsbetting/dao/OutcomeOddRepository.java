package com.training.sportsbetting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.OutcomeOdd;

@Repository
public interface OutcomeOddRepository extends JpaRepository<OutcomeOdd, Long> {

}
