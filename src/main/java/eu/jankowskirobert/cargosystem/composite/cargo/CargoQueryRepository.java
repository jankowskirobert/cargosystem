package eu.jankowskirobert.cargosystem.composite.cargo;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;

public interface CargoQueryRepository {
    TransportNumber nextTransportNumber();
}
