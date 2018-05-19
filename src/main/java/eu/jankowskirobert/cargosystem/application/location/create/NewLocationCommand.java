package eu.jankowskirobert.cargosystem.application.location.create;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
