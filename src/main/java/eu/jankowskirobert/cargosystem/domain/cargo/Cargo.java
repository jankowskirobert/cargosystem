package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.cargo.delivery.Delivery;
import eu.jankowskirobert.cargosystem.domain.cargo.delivery.DeliveryHistory;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "id")
public class Cargo {

    private CargoId id;
    private TransportNumber transportNumber;
    private Location placeOfIssue;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;
    private Delivery delivery;

    public void apply(final List<DeliveryHistory> history) {
        for (DeliveryHistory historyElement : history) {

        }
    }

    public static Cargo of(CargoId id, TransportNumber transportNumber, RouteSpecification routeSpecification, Itinerary itinerary) {
        Delivery delivery = Delivery.of(null, routeSpecification, itinerary);
        Cargo cargo = new Cargo(id, transportNumber, routeSpecification.origin(), routeSpecification, itinerary, delivery);
        return cargo;
    }

    public static Cargo newEmpty(CargoId id, TransportNumber transportNumber, RouteSpecification routeSpecification) {
        Delivery delivery = Delivery.of(null, routeSpecification, Itinerary.empty());
        Cargo cargo = new Cargo(id, transportNumber, routeSpecification.origin(), routeSpecification, Itinerary.empty(), delivery);
        return cargo;
    }


    public boolean withSameNumber(Cargo cargo){
        return this.transportNumber.equals(cargo.getTransportNumber());
    }
}
