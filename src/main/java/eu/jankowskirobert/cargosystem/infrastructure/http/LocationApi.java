package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommand;
import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

public interface LocationApi {
    void addNewLocation(@Valid final RegisterLocationCommand registerLocationCommand);
    ResponseEntity<LocationProjection> getSingleLocationById(final String id);
    ResponseEntity<Iterable<LocationProjection>> findAll();
}
