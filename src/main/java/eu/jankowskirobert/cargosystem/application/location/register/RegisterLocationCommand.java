package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor(staticName = "of")
@Builder
public class RegisterLocationCommand {

	@NotNull
	private Address address;
	@NotBlank
	private CompanyId companyId;
	private LocalDate availability;
}
