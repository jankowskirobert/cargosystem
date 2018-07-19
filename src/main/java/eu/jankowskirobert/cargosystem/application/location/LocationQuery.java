package eu.jankowskirobert.cargosystem.application.location;

import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class LocationQuery {

    private LocationQueryRepository locationQueryRepository;

    public Optional<LocationProjection> getPendingLocation(String id) {
        return locationQueryRepository.findById(id);
    }
    public Iterable<LocationProjection> getPendingLocations() {
        return locationQueryRepository.findAll();
    }
}
