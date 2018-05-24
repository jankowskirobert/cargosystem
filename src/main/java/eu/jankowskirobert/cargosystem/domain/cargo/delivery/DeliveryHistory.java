package eu.jankowskirobert.cargosystem.domain.cargo.delivery;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;

import java.math.BigDecimal;

public class DeliveryHistory {
    private Location origin;
    private Location destination;
    private TransportCompany transporter;
    private BigDecimal weight;
}
