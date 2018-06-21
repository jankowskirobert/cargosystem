package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationWriteRepository;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class RegisterLocationCommandHandler implements CommandHandler<RegisterLocationCommand, Void> {

    private final LocationWriteRepository locationQueryRepository;

    @Override
    public Void handle(RegisterLocationCommand command) {
        LocationId locationId = command.getId();
        Location newLocation = Location.of(locationId, command.getAddress(), command.getCompany(), command.getAvailability());
        locationQueryRepository.store(newLocation);
        return null;
    }

}
