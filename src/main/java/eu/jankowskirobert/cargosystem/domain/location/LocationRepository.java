package eu.jankowskirobert.cargosystem.domain.location;

import eu.jankowskirobert.cargosystem.domain.company.Company;

public interface LocationRepository {

	void store(Location newLocation) throws LocationRepositoryException, DuplicatedLocationException;

    Location find(LocationId of);
}
