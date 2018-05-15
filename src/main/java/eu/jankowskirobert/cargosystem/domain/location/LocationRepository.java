package eu.jankowskirobert.cargosystem.domain.location;

public interface LocationRepository {

	void store(Location newLocation) throws LocationRepositoryException, DuplicatedLocationException;

}
