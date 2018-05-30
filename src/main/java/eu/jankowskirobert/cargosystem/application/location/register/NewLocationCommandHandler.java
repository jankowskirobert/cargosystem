package eu.jankowskirobert.cargosystem.application.location.register;

import java.util.Objects;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.*;
import eu.jankowskirobert.cqrs.infrastructure.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
public class NewLocationCommandHandler implements CommandHandler<RegisterLocationCommand> {

    private final LocationQueryRepository locationQueryRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void handle(RegisterLocationCommand command) {
        LocationId id = LocationId.of(command.getId());
        CompanyId companyId = CompanyId.of(command.getCompanyId());
        Company company = companyRepository.find(companyId);
        if (!Objects.isNull(company)) {
            Location newLocation = Location.of(id, command.getAddress(), companyId, command.getAvailability());
            locationQueryRepository.store(newLocation);
        } else {
            throw new NewLocationCommandHandlerException("Cannot find company identified by: " + companyId.toString());
        }
    }

}
