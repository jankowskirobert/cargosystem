package eu.jankowskirobert.cargosystem.domain.cargo;

import java.util.List;

public interface CargoRepository {
    void store(Cargo cargo);

    CargoId nextCargoId();

    Cargo findFirst(TransportNumber id);
    List<Cargo> findAll(TransportNumber id);
}
