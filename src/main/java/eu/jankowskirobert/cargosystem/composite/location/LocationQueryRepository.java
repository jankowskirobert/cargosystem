package eu.jankowskirobert.cargosystem.composite.location;

import java.util.List;

public interface LocationQueryRepository {
    LocationWithAssignedCompanyViewDTO findProjection(String id);

    List<LocationWithAssignedCompanyViewDTO> findProjections();
}
