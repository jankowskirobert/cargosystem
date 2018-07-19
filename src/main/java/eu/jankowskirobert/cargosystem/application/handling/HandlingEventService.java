package eu.jankowskirobert.cargosystem.application.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventId;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingType;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.location.Location;

public interface HandlingEventService {
    HandlingEventStatus checkEvent(HandlingEventId id);

    HandlingEventId registerEvent(final HandlingType type, final TransportNumber transportNumber, final Location location);

    HandlingEventId registerEvent(final HandlingType type, final TransportNumber transportNumber, final Transit transit, final Location location);

    void handleCargoEvent(HandlingEvent event);
}
