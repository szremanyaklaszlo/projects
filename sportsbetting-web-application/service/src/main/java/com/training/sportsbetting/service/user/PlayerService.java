package com.training.sportsbetting.service.user;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Player;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public void savePlayer(Player player) {
        repository.save(player);
    }

    public Player findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("There is no player that name: " + username));
    }

    public void rechargeBalance(Player player, int amount) {
        player.setBalance(BigDecimal.valueOf(amount));
        repository.save(player);
    }
}
