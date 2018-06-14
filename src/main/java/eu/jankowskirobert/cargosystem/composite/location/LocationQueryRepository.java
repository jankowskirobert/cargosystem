package eu.jankowskirobert.cargosystem.composite.location;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;

import java.util.List;

public interface LocationQueryRepository {
    LocationWithAssignedCompanyViewDTO findProjection(String id);

    List<LocationWithAssignedCompanyViewDTO> findProjections();

    Location find(LocationId id);
}
