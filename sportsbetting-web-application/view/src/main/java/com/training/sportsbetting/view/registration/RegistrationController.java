package com.training.sportsbetting.view.registration;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.sportsbetting.domain.Currency;
import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.service.user.PlayerService;

@Controller
public class RegistrationController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("player", new PlayerModel());
        return "registration";
    }

    @PostMapping("save_player")
    public String savePlayer(@ModelAttribute("player") PlayerModel player) {
        playerService.savePlayer(new Player(player.getUsername(), player.getEmail(), passwordEncoder.encode(player.getPassword()),
                new SimpleGrantedAuthority("ROLE_USER"), player.getFirstName(), player.getLastName(), BigDecimal.valueOf(1000), Currency.USD,
                LocalDate.parse(player.getBirth())));
        return "redirect:login";
    }

}
