package com.training.sportsbetting.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.service.user.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    public void savePlayer (Player player) {
        repository.save(player);
    }

}
