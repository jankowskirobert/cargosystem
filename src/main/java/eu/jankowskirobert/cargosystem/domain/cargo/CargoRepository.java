package eu.jankowskirobert.cargosystem.domain.cargo;

import java.util.List;
/*
TODO: [bsc info] remove
There is no need to keep separate write node that even domain cannot read object.
The main reason behind Query node is to keep projection to read data fast.
Better option is to prevent from accessing repositories outside handler boundary.
[Package|Vertical|horizontal ]
 */

/**
 * Domain Cargo Repository
 */
public interface CargoRepository {
    /**
     * Store actual domain model
     * @param cargo
     */
    void store(Cargo cargo);
    CargoId nextCargoId();
    Cargo findFirst(TransportNumber id);
    List<Cargo> findAll(TransportNumber id);
    TransportNumber nextTransportNumber();

}
