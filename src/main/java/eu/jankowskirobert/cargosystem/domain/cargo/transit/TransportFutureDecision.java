package eu.jankowskirobert.cargosystem.domain.cargo.transit;

import eu.jankowskirobert.cargosystem.domain.cargo.Itinerary;
import eu.jankowskirobert.cargosystem.domain.cargo.RouteSpecification;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingActivity;

public interface TransportFutureDecision {
    HandlingActivity predict(RouteSpecification routeSpecification, Itinerary itinerary);
}
