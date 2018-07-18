package eu.jankowskirobert.cargosystem.application.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventId;

public interface HandlingEventService {
    HandlingEventStatus checkEvent(HandlingEventId id);

    public void handleCargoEvent(HandlingEvent event);
}
