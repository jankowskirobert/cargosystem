package eu.jankowskirobert.cargosystem.application.cargo.create;

import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyId;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyRepository;
import eu.jankowskirobert.cqrs.infrastructure.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewCargoCommandHandler implements CommandHandler<NewCargoCommand> {

    private CargoRepository cargoRepository;
    private CompanyRepository companyRepository;
    private TransportCompanyRepository transportCompanyRepository;
    private LocationRepository locationRepository;

    @Override
    public void handle(NewCargoCommand newCargoCommand) {
        Company company = companyRepository.find(CompanyId.of(newCargoCommand.getCompanyId()));
        TransportCompany transportCompany = transportCompanyRepository.find(TransportCompanyId.of(newCargoCommand.getTransportCompanyId()));
        Location locationFrom = locationRepository.find(LocationId.of(newCargoCommand.getLocationIdFrom()));
        Location locationTo = locationRepository.find(LocationId.of(newCargoCommand.getLocationIdTo()));
        CargoId cargoId = cargoRepository.nextCargoId();
        RouteSpecification routeSpecification = RouteSpecification.of(locationFrom,locationTo,newCargoCommand.getArrival());
        Itinerary itinerary = Itinerary.empty();
        Cargo newCargo = Cargo.of(cargoId, routeSpecification, itinerary);
        cargoRepository.store(newCargo);
    }
}
