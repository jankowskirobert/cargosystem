package eu.jankowskirobert.cargosystem.application.location.create;

import java.util.Objects;

import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cqrs.infrastructure.CommandHandler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NewLocationCommandHandler implements CommandHandler<NewLocationCommand, Void> {

	private final LocationRepository locationRepository;
	private final CompanyRepository companyRepository;

	@Override
	public Void handle(NewLocationCommand command) {

		CompanyId companyId = CompanyId.of(command.getCompanyId());
		companyRepository.find(companyId);
		if (!Objects.isNull(companyId)) {
			Location newLocation = Location.of(command.getAddress(), companyId, command.getAvailability());
			locationRepository.store(newLocation);
			return null;
		} else {
			throw new NewLocationCommandHandlerException("Cannot find company identified by: "+companyId);
		}
	}

}
