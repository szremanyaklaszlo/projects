package com.training.sportsbetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.service.dao.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    public void savePlayer (Player player) {
//        playerService.savePlayer(new Player(player.getUsername(), player.getEmail(), pswEncoder.encode(player.getPassword()),
//                new SimpleGrantedAuthority("ROLE_USER"), player.getFirstName(), player.getLastName(), BigDecimal.valueOf(1000), Currency.USD,
//                LocalDate.parse(player.getBirth())))
        repository.save(player);
    }

}
