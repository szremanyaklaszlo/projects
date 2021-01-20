package com.training.sportsbetting.service.wager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.sportsbetting.domain.Wager;

@Repository
public interface WagerRepository extends JpaRepository<Wager, Long> {

    @Query(value = "SELECT wager FROM Wager wager WHERE wager.processed is FALSE")
    public List<Wager> findActiveWagers ();

}
