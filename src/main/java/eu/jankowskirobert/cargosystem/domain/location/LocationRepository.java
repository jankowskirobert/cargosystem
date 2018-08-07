package eu.jankowskirobert.cargosystem.domain.location;

import java.util.Optional;

public interface LocationRepository {
    void store(Location newLocation);
    Optional<Location> find(LocationId locationId);
}
