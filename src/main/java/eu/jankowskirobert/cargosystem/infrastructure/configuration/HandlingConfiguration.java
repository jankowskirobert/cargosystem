package eu.jankowskirobert.cargosystem.infrastructure.configuration;

import eu.jankowskirobert.cargosystem.application.handling.HandlingEventService;
import eu.jankowskirobert.cargosystem.application.handling.HandlingService;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventRepository;
import org.springframework.context.annotation.Bean;

public class HandlingConfiguration {

    @Bean
    public HandlingEventRepository handlingEventRepository(){
        return new HandlingEventRepository() {
            @Override
            public void store(HandlingEvent handlingEvent) {

            }
        };
    }

    @Bean
    public HandlingEventService handlingEventService(HandlingEventRepository handlingEventRepository){
        return HandlingService.of(handlingEventRepository);
    }
}
