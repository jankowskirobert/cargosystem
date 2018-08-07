package eu.jankowskirobert.cargosystem.infrastructure.configuration;

import eu.jankowskirobert.cargosystem.application.cargo.handlers.RegisterCargoCommandHandler;
import eu.jankowskirobert.cargosystem.composite.cargo.RegisterCargoCommandFactory;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.InMemoryCargo;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargoConfiguration {

    @Autowired
    LocationQueryRepository locationQueryRepository;

    @Bean
    public CargoRepository cargoRepository() {
        return new InMemoryCargo();
    }

    @Bean
    public RegisterCargoCommandHandler registerCargoCommandHandler(CargoRepository cargoRepository, ApplicationEventPublisher applicationEventPublisher){
        return RegisterCargoCommandHandler.of(cargoRepository, applicationEventPublisher);
    }

    @Bean
    public RegisterCargoCommandFactory registerCargoCommandFactory(LocationRepository locationRepository){
        return RegisterCargoCommandFactory.of(locationRepository);
    }

}
