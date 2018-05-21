package eu.jankowskirobert.cargosystem.domain.cargo;

public interface CargoRepository {
    void store(Cargo cargo);

    CargoId nextCargoId();

    Cargo find(CargoId id);
}
