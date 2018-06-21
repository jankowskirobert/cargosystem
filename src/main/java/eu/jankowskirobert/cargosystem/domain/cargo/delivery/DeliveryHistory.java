package eu.jankowskirobert.cargosystem.domain.cargo.delivery;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class DeliveryHistory {
    private Location origin;
    private Location destination;
    private TransportCompany transporter;
    private BigDecimal weight;
}
