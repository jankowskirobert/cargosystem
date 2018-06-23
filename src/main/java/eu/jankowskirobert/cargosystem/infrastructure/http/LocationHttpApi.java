package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.application.location.LocationQuery;
import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommandHandler;
import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor(staticName = "of")
@RestController
@RequestMapping(value = "/location")
public class LocationHttpApi {
	
	private final RegisterLocationCommandHandler registerLocationCommandHandler;
	private final LocationQuery locationQuery;
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void addNewLocation(@Valid final RegisterLocationCommand registerLocationCommand) {
		registerLocationCommandHandler.handle(registerLocationCommand);
	}

	@RequestMapping(value = "find", method = RequestMethod.GET)
	public LocationProjection addNewLocation(final String id) {

		return locationQuery.getPendingLocation(id).orElseThrow(() -> new NullPointerException());
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public Iterable<LocationProjection> addNewLocation() {
		return locationQuery.getPendingLocations();
	}
}
