package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommand;
import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommandHandler;
import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor(staticName = "of")
@RestController
@RequestMapping(value = "/location")
public class LocationHttpApi implements LocationApi {

    private final RegisterLocationCommandHandler registerLocationCommandHandler;
    private final LocationQueryRepository locationQueryRepository;

    @Override
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public void addNewLocation(final RegisterLocationCommand registerLocationCommand) {
        registerLocationCommandHandler.handle(registerLocationCommand);
    }

    @Override
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ResponseEntity<LocationProjection> getSingleLocationById(final String id) {
        return ResponseEntity.ok(locationQueryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Location not found")));
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<LocationProjection>> findAll() {
        return ResponseEntity.ok(locationQueryRepository.findAll());
    }
}
