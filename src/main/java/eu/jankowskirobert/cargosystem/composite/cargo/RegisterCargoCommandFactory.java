package eu.jankowskirobert.cargosystem.composite.cargo;

import eu.jankowskirobert.cargosystem.application.cargo.commands.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCargoCommandFactory {

    private LocationQueryRepository locationQueryRepository;
    private CargoQueryRepository cargoQueryRepository;

    public RegisterCargoCommand cargo(RegisterCargoDTO registerCargoDTO) {
        TransportNumber transportNumber = TransportNumber.random();
        Optional<LocationProjection> locationFrom = locationQueryRepository.findById(registerCargoDTO.locationFrom());
        Optional<LocationProjection> locationTo = locationQueryRepository.findById(registerCargoDTO.locationTo());
        if (locationFrom.isPresent() && locationTo.isPresent()) {
            LocationProjection lF = locationFrom.orElseThrow(() -> new IllegalAccessError());
            LocationProjection lT = locationTo.orElseThrow(()-> new IllegalAccessError());
            Location mapperFrom = Location.of(LocationId.of(lF.getId()), lF.getAddress(), Company.of(CompanyId.of(lF.getCompanyId()), lF.getCompanyName(), null), lF.getAvailability());
            Location mapperTo = Location.of(LocationId.of(lT.getId()), lT.getAddress(), Company.of(CompanyId.of(lT.getCompanyId()), lT.getCompanyName(), null), lT.getAvailability());
            return RegisterCargoCommand.of(transportNumber, registerCargoDTO.name(), mapperFrom, mapperTo, registerCargoDTO.arrival());
        } else
            return null;
    }
}

