package com.training.sportsbetting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.Outcome;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

}
