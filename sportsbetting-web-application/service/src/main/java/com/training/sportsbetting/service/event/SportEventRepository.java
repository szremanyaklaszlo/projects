package com.training.sportsbetting.service.event;

import javax.transaction.Transactional;

import com.training.sportsbetting.domain.SportEvent;

@Transactional
public interface SportEventRepository extends SportEventBaseRepository<SportEvent> {

}
