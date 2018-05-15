package eu.jankowskirobert.cargosystem.application.location.create;

import java.util.Objects;

import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.*;
import eu.jankowskirobert.cqrs.infrastructure.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.ValidatorFactory;

@Validated
@AllArgsConstructor
public class NewLocationCommandHandler implements CommandHandler<NewLocationCommand> {

    private final LocationRepository locationRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void handle(NewLocationCommand command) {
        LocationId id = LocationId.of(command.getId());
        CompanyId companyId = CompanyId.of(command.getCompanyId());
        companyRepository.find(companyId);
        if (!Objects.isNull(companyId)) {
            Location newLocation = Location.of(id, command.getAddress(), companyId, command.getAvailability());
            locationRepository.store(newLocation);
        } else {
            throw new NewLocationCommandHandlerException("Cannot find company identified by: " + companyId);
        }
    }

}
