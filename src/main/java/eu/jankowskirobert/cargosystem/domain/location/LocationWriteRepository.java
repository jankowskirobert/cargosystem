package eu.jankowskirobert.cargosystem.domain.location;

import eu.jankowskirobert.cargosystem.domain.location.Location;

public interface LocationWriteRepository {
    void store(Location newLocation);
}
