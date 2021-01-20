package com.training.sportsbetting.service.event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.training.sportsbetting.domain.SportEvent;

@NoRepositoryBean
public interface SportEventBaseRepository<T extends SportEvent> extends JpaRepository<T, Long>{

    @Query(value = "SELECT sportEvent FROM SportEvent sportEvent WHERE sportEvent.startTime > CURDATE()")
    public List<SportEvent> findActiveSportEvents ();

}
