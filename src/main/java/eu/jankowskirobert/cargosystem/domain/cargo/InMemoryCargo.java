package eu.jankowskirobert.cargosystem.domain.cargo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryCargo implements CargoRepository {

    Set<Cargo> cargos = new HashSet<>();

    @Override
    public void store(Cargo cargo) {
        if (!cargos.add(cargo)) throw new CargoRepositoryException();
    }

    @Override
    public CargoId nextCargoId() {
        return CargoId.random();
    }

    @Override
    public List<Cargo> findAll(TransportNumber id) {
        return cargos.stream().filter(x -> x.getTransportNumber().equals(id)).collect(Collectors.toList());
    }

    @Override
    public TransportNumber nextTransportNumber() {
        return TransportNumber.random();
    }

    @Override
    public Cargo findFirst(TransportNumber id) {
        return cargos.stream().filter(x -> x.getTransportNumber().equals(id)).findFirst().orElse(null);
    }
}
