package eu.jankowskirobert.cargosystem.domain.cargo;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cargo {

    private CargoId id;
    private TransportCompany transportCompany;
    private Company orderingCompany;
    private Location placeOfIssue;
    private String name;
    private BigDecimal weight;
    private List<DeliveryHistory> deliveryHistory;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;
    private Delivery delivery;

    public void apply(final List<DeliveryHistory> history) {
        for (DeliveryHistory historyElement : history) {

        }
    }
}
