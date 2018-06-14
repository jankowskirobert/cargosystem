package eu.jankowskirobert.cargosystem.composite.cargo;

import eu.jankowskirobert.cargosystem.application.cargo.commands.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCargoCommandFactory {

    private LocationQueryRepository locationQueryRepository;
    private CargoQueryRepository cargoQueryRepository;

    public RegisterCargoCommand cargo(RegisterCargoDTO registerCargoDTO) {
        TransportNumber transportNumber = cargoQueryRepository.nextTransportNumber();
        Location locationFrom = locationQueryRepository.find(LocationId.of(registerCargoDTO.locationFrom()));
        Location locationTo = locationQueryRepository.find(LocationId.of(registerCargoDTO.locationTo()));
        return RegisterCargoCommand.of(transportNumber, registerCargoDTO.name(), locationFrom, locationTo, registerCargoDTO.arrival());
    }
}

