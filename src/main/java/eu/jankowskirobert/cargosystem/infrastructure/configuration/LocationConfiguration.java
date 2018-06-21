package eu.jankowskirobert.cargosystem.infrastructure.configuration;

import eu.jankowskirobert.cargosystem.application.location.LocationQuery;
import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommandHandler;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.location.LocationWriteRepository;
import eu.jankowskirobert.cargosystem.standalone.LocationDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfiguration {

    private LocationDB locationDB = new LocationDB();

    @Bean
    public LocationQuery locationQuery(LocationQueryRepository locationQueryRepository){
        return LocationQuery.of(locationQueryRepository);
    }

    @Bean
    public RegisterLocationCommandHandler registerLocationCommandHandler(LocationWriteRepository locationWriteRepository) {
        return RegisterLocationCommandHandler.of(locationWriteRepository);
    }

    @Bean
    public LocationQueryRepository locationQueryRepository() {
        return locationDB;
    }

    @Bean
    public LocationWriteRepository locationWriteRepository() {
        return locationDB;
    }
}
