package com.training.sportsbetting.view.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.service.user.PlayerService;
import com.training.sportsbetting.service.user.model.PlayerModel;
import com.training.sportsbetting.service.user.model.PlayerModelBuilder;
import com.training.sportsbetting.service.user.security.AuthenticationChecker;
import com.training.sportsbetting.view.bet.BetController;
import com.training.sportsbetting.view.events.EventsController;
import com.training.sportsbetting.view.home.HomeController;
import com.training.sportsbetting.view.profile.ProfileController;

@ControllerAdvice(basePackageClasses = { HomeController.class, EventsController.class, ProfileController.class, BetController.class})
public class PlayerModelAttributeProvider {

    @Autowired
    private AuthenticationChecker authenticationChecker;
    @Autowired
    private PlayerModelBuilder playerModelBuilder;
    @Autowired
    private PlayerService playerService;

    @ModelAttribute("player")
    public void player(Model model) {
        if (authenticationChecker.isAuthenticated()) {
            String playerName = getPlayerName();
            PlayerModel player = getPlayerModel(playerName);
            model.addAttribute("player", player);
        }
    }

    private String getPlayerName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private PlayerModel getPlayerModel(String playerName) {
        Player player = playerService.findByUsername(playerName);
        return playerModelBuilder
                .setFirstName(player.getFirstName())
                .setLastName(player.getLastName())
                .setUsername(player.getUsername())
                .setEmail(player.getEmail())
                .setCurrency(player.getCurrency())
                .setBalance(player.getBalance())
                .setBirth(player.getBirth())
                .build();
    }
}
