package com.training.sportsbetting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.domain.Wager;

@Repository
public interface WagerRepository extends JpaRepository<Wager, Long> {

    List<Wager> findByPlayer(Player player);

}
