package com.training.sportsbetting.service.event;

import java.util.Comparator;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.training.sportsbetting.domain.SportEvent;

@Service
public class SportEventComparator {

    public Comparator<? extends SportEvent> sortByTitleAscend(){
        return (o1, o2) -> o1.getTitle().compareTo(o2.getTitle());
    }
    
    public Comparator<? extends SportEvent> sortByTitleDescend(){
        return sortByTitleAscend().reversed();
    }
    
    public Comparator<Entry<? extends SportEvent, Integer>> sortByPopularityDescend(){
        return Comparator.comparing(Entry::getValue, Comparator.reverseOrder());
    }
    
    public Comparator<Entry<? extends SportEvent, Integer>> sortByStartDateAscend(){
        return (o1, o2) -> o1.getKey().getStartTime().compareTo(o2.getKey().getStartTime());
    }
    
    public Comparator<Entry<? extends SportEvent, Integer>> sortByStartDateDescend(){
        return sortByStartDateAscend().reversed();
    }
    
}
