package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.application.location.LocationQuery;
import eu.jankowskirobert.cargosystem.composite.location.LocationWithAssignedCompanyViewDTO;
import eu.jankowskirobert.cargosystem.application.location.register.RegisterLocationCommand;
import eu.jankowskirobert.cqrs.CommandExecutor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController("/location")
public class LocationHttpApi {
	
	private final CommandExecutor commandHandler;
	private final LocationQuery locationQuery;
	
	@PostMapping(path = "/new")
	public void addNewLocation(@Valid final RegisterLocationCommand registerLocationCommand) {
		commandHandler.asyncExecutor(registerLocationCommand);
	}

	@GetMapping(path = "/find")
	public LocationWithAssignedCompanyViewDTO addNewLocation(final String id) {
		return locationQuery.getPendingLocation(id);
	}

	@GetMapping(path = "/all")
	public List<LocationWithAssignedCompanyViewDTO> addNewLocation() {
		return locationQuery.getPendingLocations();
	}
}
