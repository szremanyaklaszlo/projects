package com.training.sportsbetting.service.event.outcome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.Outcome;

@Service
public class OutcomeService {

    @Autowired
    private OutcomeRepository outcomeRepository;

    public List<Outcome> findAll() {
        return outcomeRepository.findAll();
    }

}
