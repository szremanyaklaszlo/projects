package com.training.sportsbetting.service.wager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Wager;
import com.training.sportsbetting.service.wager.repository.WagerRepository;

@Service
public class WagerService {

    @Autowired
    private WagerRepository wagerRepository;

    public List<Wager> findAll() {
        return wagerRepository.findAll();
    }
}
