package com.training.sportsbetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.dao.PlayerRepository;
import com.training.sportsbetting.domain.Player;

@Service
public class PlayerService {
    
    @Autowired
    PlayerRepository repository;
    
    public void savePlayer (Player player) {
        repository.save(player);
    }

}
