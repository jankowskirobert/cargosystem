package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationQueryRepository;
import eu.jankowskirobert.cqrs.infrastructure.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
public class RegisterLocationCommandHandler implements CommandHandler<RegisterLocationCommand, Void> {

    private final LocationQueryRepository locationQueryRepository;

    @Override
    public Void handle(RegisterLocationCommand command) {
        LocationId locationId = LocationId.random();
        Location newLocation = Location.of(locationId, command.getAddress(), command.getCompanyId(), command.getAvailability());
        locationQueryRepository.store(newLocation);
        return null;
    }

}
