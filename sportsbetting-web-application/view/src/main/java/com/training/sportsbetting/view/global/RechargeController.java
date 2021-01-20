package com.training.sportsbetting.view.global;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.service.user.PlayerService;
import com.training.sportsbetting.service.user.security.AuthenticationChecker;
import com.training.sportsbetting.view.events.EventsController;
import com.training.sportsbetting.view.home.HomeController;

@Controller
@ControllerAdvice(basePackageClasses = { HomeController.class, EventsController.class })
public class RechargeController {

    private static final int HUF_RECHARGE_AMOUNT = 100000;
    private static final int USD_RECHARGE_AMOUNT = 300;
    private static final int EUR_RECHARGE_AMOUNT = 250;
    private static final double MINIMUM_LIMIT_RATE = 0.2;

    @Autowired
    private AuthenticationChecker authenticationChecker;

    @Autowired
    private PlayerService playerService;

    @PostMapping("recharge")
    public String rechargeBalance(HttpServletRequest request) {
        Player player = getPlayer();
        int amount = calculateRechargeAmount(player);
        playerService.rechargeBalance(player, amount);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @ModelAttribute("rechargeBoundary")
    public double rechargeBoundary() {
        double result = 0;
        if (authenticationChecker.isAuthenticated()) {
            Player player = getPlayer();
            int amount = calculateRechargeAmount(player);
            result = amount * MINIMUM_LIMIT_RATE;
        }
        return result;
    }

    private Player getPlayer() {
        String playerName = SecurityContextHolder.getContext().getAuthentication().getName();
        return playerService.findByUsername(playerName);
    }

    private int calculateRechargeAmount(Player player) {
        int amount = 0;
        switch (player.getCurrency()) {
        case EUR:
            amount = EUR_RECHARGE_AMOUNT;
            break;
        case USD:
            amount = USD_RECHARGE_AMOUNT;
            break;
        case HUF:
            amount = HUF_RECHARGE_AMOUNT;
            break;
        }
        return amount;
    }
}
