package eu.jankowskirobert.cargosystem.domain.cargo;

public interface TransportFutureDecision {
    HandlingActivity predict(RouteSpecification routeSpecification, Itinerary itinerary);
}
