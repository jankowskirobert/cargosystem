package eu.jankowskirobert.cargosystem.application.location;

import eu.jankowskirobert.cargosystem.composite.location.LocationWithAssignedCompanyViewDTO;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class LocationQuery {

    private LocationQueryRepository locationQueryRepository;

    public LocationWithAssignedCompanyViewDTO getPendingLocation(String id) {
        return locationQueryRepository.findProjection(id);
    }
    public List<LocationWithAssignedCompanyViewDTO> getPendingLocations() {
        return locationQueryRepository.findProjections();
    }
}
