package eu.jankowskirobert.cargosystem.domain.location;

import java.time.LocalDate;

import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.*;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
@EqualsAndHashCode(of = {"id"})
public class Location {
	private LocationId id;
	private Address address;
	private CompanyId companyId;
	private LocalDate availability;
}
