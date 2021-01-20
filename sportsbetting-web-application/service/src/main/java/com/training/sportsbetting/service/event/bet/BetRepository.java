package com.training.sportsbetting.service.event.bet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

}
