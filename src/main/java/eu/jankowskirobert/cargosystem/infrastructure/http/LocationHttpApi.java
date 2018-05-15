package eu.jankowskirobert.cargosystem.infrastructure.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.jankowskirobert.cargosystem.application.location.create.NewLocationCommand;
import eu.jankowskirobert.cqrs.CommandExecutor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController("/location")
public class LocationHttpApi {
	
	private final CommandExecutor commandHandler;
	
	@PostMapping(path = "/new")
	public void addNewLocation(final NewLocationCommand newLocationCommand) {
		commandHandler.asyncExecutor(newLocationCommand);
	}
	
}
