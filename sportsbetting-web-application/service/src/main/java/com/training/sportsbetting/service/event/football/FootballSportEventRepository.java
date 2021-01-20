package com.training.sportsbetting.service.event.football;

import javax.transaction.Transactional;

import com.training.sportsbetting.domain.FootballSportEvent;
import com.training.sportsbetting.service.event.SportEventBaseRepository;

@Transactional
public interface FootballSportEventRepository extends SportEventBaseRepository<FootballSportEvent> {

}
