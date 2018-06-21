package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor(staticName = "of")
@Builder
public class RegisterLocationCommand {
    @NotNull
    private LocationId id;
	@NotNull
	private Address address;
	@NotNull
	private Company company;
	private LocalDate availability;
}
