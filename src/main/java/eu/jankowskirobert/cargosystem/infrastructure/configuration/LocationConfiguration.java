package eu.jankowskirobert.cargosystem.infrastructure.configuration;

import eu.jankowskirobert.cargosystem.application.location.LocationQuery;
import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommandHandler;
import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.location.LocationWriteRepository;
import eu.jankowskirobert.cargosystem.standalone.LocationDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfiguration {

    private LocationDB locationDB = new LocationDB();
    @Autowired
    LocationQueryRepository locationQueryRepository;
    @Bean
    public LocationQuery locationQuery(){
        locationQueryRepository.save(LocationProjection.builder().id("asd").build());
        return LocationQuery.of(locationQueryRepository);
    }

    @Bean
    public RegisterLocationCommandHandler registerLocationCommandHandler(LocationWriteRepository locationWriteRepository, LocationQueryRepository locationQueryRepository) {
        return RegisterLocationCommandHandler.of(locationWriteRepository, locationQueryRepository);
    }

    @Bean
    public LocationWriteRepository locationWriteRepository() {
        return locationDB;
    }
}
