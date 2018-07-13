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
            LocationProjection locationFromProjection = locationFrom.orElseThrow(() -> new IllegalAccessError());
            LocationProjection locationToProjection = locationTo.orElseThrow(() -> new IllegalAccessError());
            Location mapperFrom = Location.of(
                    LocationId.of(locationFromProjection.getId()),
                    locationFromProjection.getAddress(),
                    Company.builder()
                            .companyId(CompanyId.of(locationFromProjection.getCompanyId()))
                            .name(locationFromProjection.getCompanyName())
                            .build(),
                    locationFromProjection.getAvailability());
            Location mapperTo = Location.of(
                    LocationId.of(locationToProjection.getId()),
                    locationToProjection.getAddress(),
                    Company.builder()
                            .companyId(CompanyId.of(locationToProjection.getCompanyId()))
                            .name(locationToProjection.getCompanyName())
                            .build(),
                    locationToProjection.getAvailability());
            return RegisterCargoCommand.of(transportNumber, registerCargoDTO.name(), mapperFrom, mapperTo, registerCargoDTO.arrival());
        } else
            return null;
    }
}

