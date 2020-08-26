package com.training.sportsbetting.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}