package eu.jankowskirobert.cargosystem.domain.location;

public interface LocationWriteRepository {
    void store(Location newLocation);
}
