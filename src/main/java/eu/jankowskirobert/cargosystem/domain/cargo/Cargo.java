package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.cargo.delivery.Delivery;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingHistory;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "id")
public class Cargo {

    private CargoId cargoId;
    private TransportNumber transportNumber;
    private Location placeOfIssue;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;
    private Delivery delivery;

    public static Cargo of(CargoId id, TransportNumber transportNumber, RouteSpecification routeSpecification, Itinerary itinerary) {
        Delivery delivery = Delivery.of(routeSpecification,itinerary,HandlingHistory.empty());
        Cargo cargo = new Cargo(id, transportNumber, routeSpecification.origin(), routeSpecification, itinerary, delivery);
        return cargo;
    }

    public static Cargo newEmpty(CargoId id, TransportNumber transportNumber, RouteSpecification routeSpecification) {
        Itinerary empty = Itinerary.empty();
        Delivery delivery = Delivery.of(routeSpecification, empty, HandlingHistory.empty());
        Cargo cargo = new Cargo(id, transportNumber, routeSpecification.origin(), routeSpecification, empty, delivery);
        return cargo;
    }

    public boolean withSameNumber(Cargo cargo){
        return this.transportNumber.equals(cargo.getTransportNumber());
    }
}
