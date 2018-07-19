package eu.jankowskirobert.cargosystem.infrastructure.configuration;

import eu.jankowskirobert.cargosystem.application.cargo.handlers.RegisterCargoCommandHandler;
import eu.jankowskirobert.cargosystem.composite.cargo.RegisterCargoCommandFactory;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Configuration
public class CargoConfiguration {

    @Autowired
    LocationQueryRepository locationQueryRepository;

    @Bean
    public CargoRepository cargoRepository() {
        return new CargoRepository() {

            Set<Cargo> cargos = new HashSet<>();

            @Override
            public void store(Cargo cargo) {
                if (!cargos.add(cargo)) throw new CargoRepositoryException();
            }

            @Override
            public CargoId nextCargoId() {
                return CargoId.of(UUID.randomUUID().toString());
            }

            @Override
            public List<Cargo> findAll(TransportNumber id) {
                return cargos.stream().filter(x -> x.getTransportNumber().equals(id)).collect(Collectors.toList());
            }

            @Override
            public Cargo findFirst(TransportNumber id) {
                return cargos.stream().filter(x -> x.getTransportNumber().equals(id)).findFirst().orElse(null);
            }
        };
    }

    @Bean
    public RegisterCargoCommandHandler registerCargoCommandHandler(CargoRepository cargoRepository, ApplicationEventPublisher applicationEventPublisher){
        return RegisterCargoCommandHandler.of(cargoRepository, applicationEventPublisher);
    }

    @Bean
    public RegisterCargoCommandFactory registerCargoCommandFactory(){
        return RegisterCargoCommandFactory.of(locationQueryRepository);
    }

}
