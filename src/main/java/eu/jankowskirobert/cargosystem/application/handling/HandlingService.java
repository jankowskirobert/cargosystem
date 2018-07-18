package eu.jankowskirobert.cargosystem.application.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventId;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventRepository;

public class HandlingService implements HandlingEventService {

    private HandlingEventRepository handlingEventRepository;

    @Override
    public HandlingEventStatus checkEvent(HandlingEventId id) {
        return null;
    }

    @Override
    public void handleCargoEvent(HandlingEvent event) {


        handlingEventRepository.store(event);
    }

}
