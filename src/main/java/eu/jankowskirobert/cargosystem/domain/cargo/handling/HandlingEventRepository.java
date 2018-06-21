package eu.jankowskirobert.cargosystem.domain.cargo.handling;

public interface HandlingEventRepository {
    void store(HandlingEvent handlingEvent);
}
