package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;

public interface CargoQueryRepository {
    TransportNumber nextTransportNumber();
}
