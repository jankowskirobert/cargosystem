package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.composite.location.LocationProjection;
import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class RegisterLocationCommandHandler implements CommandHandler<RegisterLocationCommand, Void> {

    private final LocationRepository locationRepository;
    private final LocationQueryRepository locationQueryRepository;


    @Override
    public Void handle(RegisterLocationCommand command) {
        LocationId locationId = command.getId();
        Location newLocation = Location.of(locationId, command.getAddress(), command.getCompany(), command.getAvailability());
        locationRepository.store(newLocation);
//        Optional<LocationProjection> locationProjection = locationQueryRepository.findById(locationId.getCargoId());\
        LocationProjection projection = LocationProjection.builder().id(locationId.getId()).address(newLocation.getAddress()).availability(newLocation.getAvailability()).companyName(newLocation.getCompany().getName()).build();
        locationQueryRepository.save(projection);
        return null;
    }

}
