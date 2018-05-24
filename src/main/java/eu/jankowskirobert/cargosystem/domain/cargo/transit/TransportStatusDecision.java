package eu.jankowskirobert.cargosystem.domain.cargo.transit;

import eu.jankowskirobert.cargosystem.domain.cargo.delivery.DeliveryStatus;

public interface TransportStatusDecision {
    DeliveryStatus obtain();
}
