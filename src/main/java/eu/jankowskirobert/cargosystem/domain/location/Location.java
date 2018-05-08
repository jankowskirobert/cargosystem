package eu.jankowskirobert.cargosystem.domain.location;

import java.time.LocalDate;

import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
public class Location {
	private Address address;
	private CompanyId companyId;
	private LocalDate availability;
}
