package eu.jankowskirobert.cargosystem.domain.location;

import eu.jankowskirobert.cargosystem.domain.company.Company;

public interface LocationQueryRepository {

	void store(Location newLocation) throws LocationRepositoryException, DuplicatedLocationException;

    Location find(LocationId of);
}
