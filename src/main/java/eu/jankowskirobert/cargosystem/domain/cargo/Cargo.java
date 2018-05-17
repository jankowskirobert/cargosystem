package eu.jankowskirobert.cargosystem.domain.cargo;

import java.math.BigDecimal;
import java.util.List;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.freight.Freight;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cargo {

    private CargoId id;
    private TransportCompany transportCompany;
    private Company orderingCompany;
    private Location placeOfIssue;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;
    private Delivery delivery;
    private Freight freight;

    public void apply(final List<DeliveryHistory> history) {
        for (DeliveryHistory historyElement : history) {

        }
    }

    public Cargo of(CargoId id, RouteSpecification routeSpecification, Itinerary itinerary) {
        Delivery delivery = Delivery.of(routeSpecification, itinerary);
        Cargo cargo = new Cargo(id,TransportCompany.empty(), Company.empty(), routeSpecification.origin(), routeSpecification, itinerary,delivery, null );
        return cargo;
    }
}
