package eu.jankowskirobert.cargosystem.domain.location;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
@EqualsAndHashCode(of = {"id"})
public class Location {
	private LocationId id;
	private Address address;
	private Company companyId;
	private LocalDate availability;
}
