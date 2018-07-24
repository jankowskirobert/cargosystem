package eu.jankowskirobert.cargosystem.infrastructure.configuration;

import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommandHandler;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.infrastructure.InMemoryLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfiguration {

    private InMemoryLocation inMemoryLocation = new InMemoryLocation();
    @Autowired
    LocationQueryRepository locationQueryRepository;

    @Bean
    public RegisterLocationCommandHandler registerLocationCommandHandler(LocationRepository locationRepository, LocationQueryRepository locationQueryRepository) {
        return RegisterLocationCommandHandler.of(locationRepository, locationQueryRepository);
    }

    @Bean
    public LocationRepository locationWriteRepository() {
        return inMemoryLocation;
    }
}
