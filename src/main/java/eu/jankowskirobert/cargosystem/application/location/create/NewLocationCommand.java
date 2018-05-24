package eu.jankowskirobert.cargosystem.application.location.create;

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
public class NewLocationCommand {

	@NotBlank
    private String id;
	@NotNull
	private Address address;
	@NotBlank
	private String companyId;	
	private LocalDate availability;
}
