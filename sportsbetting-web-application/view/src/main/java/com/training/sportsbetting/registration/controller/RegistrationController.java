package com.training.sportsbetting.registration.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.sportsbetting.domain.Currency;
import com.training.sportsbetting.domain.Player;
import com.training.sportsbetting.service.PlayerService;

@Controller
public class RegistrationController {

    @Autowired
    PlayerService service;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistration(HttpServletRequest request) {
        System.out.println(request.getParameter("email"));
        service.savePlayer(new Player(
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("name"),
                BigDecimal.valueOf(Double.valueOf(request.getParameter("balance"))),
                Currency.valueOf(request.getParameter("currency")),
                LocalDate.parse(request.getParameter("birth")) ));
        return "redirect:login";
    }

}
