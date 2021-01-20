package com.training.sportsbetting.service.event.tennis;

import javax.transaction.Transactional;

import com.training.sportsbetting.domain.TennisSportEvent;
import com.training.sportsbetting.service.event.SportEventBaseRepository;
@Transactional
public interface TennisSportEventRepository extends SportEventBaseRepository<TennisSportEvent> {

}
