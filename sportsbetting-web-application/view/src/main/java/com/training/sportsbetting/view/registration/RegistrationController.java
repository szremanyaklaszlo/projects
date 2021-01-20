package com.training.sportsbetting.view.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.service.user.PlayerBuilder;
import com.training.sportsbetting.service.user.PlayerService;

@Controller
public class RegistrationController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerBuilder playerBuilder;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("registrationModel", new RegistrationModel());
        return "registration";
    }

    @PostMapping("save_player")
    public String savePlayer(@ModelAttribute("registrationModel") RegistrationModel registrationModel) {
        Player player = playerBuilder
                .setFirstName(registrationModel.getFirstName())
                .setLastName(registrationModel.getLastName())
                .setUsername(registrationModel.getUsername())
                .setPassword(passwordEncoder.encode(registrationModel.getPassword()))
                .setEmail(registrationModel.getEmail())
                .setCurrency(registrationModel.getCurrency())
                .setBirth(registrationModel.getBirth())
                .setGrantedAuthority(new SimpleGrantedAuthority("ROLE_USER"))
                .build();
        playerService.savePlayer(player);
        return "redirect:login";
    }

}
