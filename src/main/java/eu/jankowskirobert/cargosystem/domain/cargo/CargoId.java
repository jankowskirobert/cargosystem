package eu.jankowskirobert.cargosystem.domain.cargo;

import java.util.UUID;

import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyId;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyId.TransportCompanyIdBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
public class CargoId {
	private String id;
	
	public static CargoId generate() {
		return of(UUID.randomUUID().toString());
	}
}
