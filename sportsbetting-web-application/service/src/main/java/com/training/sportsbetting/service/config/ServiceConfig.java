package com.training.sportsbetting.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.training.sportsbetting.domain.config.DomainConfig;
import com.training.sportsbetting.service.event.SportEventRepository;
import com.training.sportsbetting.service.event.SportEventService;
import com.training.sportsbetting.service.event.football.FootballSportEventRepository;
import com.training.sportsbetting.service.event.football.FootballSportEventService;
import com.training.sportsbetting.service.event.tennis.TennisSportEventRepository;
import com.training.sportsbetting.service.event.tennis.TennisSportEventService;

@Configuration
@EnableAspectJAutoProxy
@EnableJpaRepositories("com.training.sportsbetting.service")
@ComponentScan(basePackages = "com.training.sportsbetting.service")
@Import(value = DomainConfig.class)
public class ServiceConfig {

    @Autowired
    private SportEventRepository sportEventRepository;
    @Autowired
    private FootballSportEventRepository footballSportEventRepository;
    @Autowired
    private TennisSportEventRepository tennisSportEventRepository;

    @Bean
    public SportEventService sportEventService (){
        SportEventService service = new SportEventService();
        service.setSportEventRepository(sportEventRepository);
        return service;
    }

    @Bean
    public FootballSportEventService footballSportEventService (){
        FootballSportEventService service = new FootballSportEventService();
        service.setSportEventRepository(footballSportEventRepository);
        return service;
    }

    @Bean
    public TennisSportEventService tennisSportEventService (){
        TennisSportEventService service = new TennisSportEventService();
        service.setSportEventRepository(tennisSportEventRepository);
        return service;
    }
}
