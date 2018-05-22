package eu.jankowskirobert.cargosystem.application.cargo.modify;

import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyRepository;
import eu.jankowskirobert.cqrs.infrastructure.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModifyCargoCommandHandler implements CommandHandler<ModifyCargoCommand> {

    private CargoRepository cargoRepository;
    private CompanyRepository companyRepository;
    private TransportCompanyRepository transportCompanyRepository;
    private LocationRepository locationRepository;

    @Override
    public void handle(ModifyCargoCommand modifyCargoCommand) {
/*        Company company = companyRepository.find(CompanyId.of(newCargoCommand.getCompanyId()));
        TransportCompany transportCompany = transportCompanyRepository.find(TransportCompanyId.of(newCargoCommand.getTransportCompanyId()));
        Location locationFrom = locationRepository.find(LocationId.of(newCargoCommand.getLocationIdFrom()));
        Location locationTo = locationRepository.find(LocationId.of(newCargoCommand.getLocationIdTo()));
        CargoId cargoId = CargoId.of(newCargoCommand.getId());
        RouteSpecification routeSpecification = RouteSpecification.of(locationFrom, locationTo, newCargoCommand.getArrival());
        Itinerary itinerary = Itinerary.empty();
        Cargo newCargo = Cargo.of(cargoId, routeSpecification, itinerary);
        cargoRepository.store(newCargo);*/
    }

}
