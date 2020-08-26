package com.training.sportsbetting.service.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.TennisSportEvent;
@Repository
public interface TennisSportEventRepository extends JpaRepository<TennisSportEvent, Long> {

    TennisSportEvent findByTitle(String title);

}
