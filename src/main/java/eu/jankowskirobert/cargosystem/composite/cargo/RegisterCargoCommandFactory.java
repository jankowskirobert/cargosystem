package eu.jankowskirobert.cargosystem.composite.cargo;

import eu.jankowskirobert.cargosystem.application.cargo.commands.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCargoCommandFactory {

    private LocationRepository locationRepository;
    public RegisterCargoCommand cargo(RegisterCargoDTO registerCargoDTO) {
        TransportNumber transportNumber = TransportNumber.random();
        Optional<Location> locationFrom = locationRepository.find(LocationId.of(registerCargoDTO.locationFrom()));
        Optional<Location> locationTo = locationRepository.find(LocationId.of(registerCargoDTO.locationTo()));
        if (locationFrom.isPresent() && locationTo.isPresent()) {
            Location from = locationFrom.orElseThrow(() -> new CommandFactoryException());
            Location to = locationFrom.orElseThrow(() -> new CommandFactoryException());
            return RegisterCargoCommand.of(transportNumber, registerCargoDTO.name(), from, to, registerCargoDTO.arrival());
        } else
            throw new CommandFactoryException();
    }
}

