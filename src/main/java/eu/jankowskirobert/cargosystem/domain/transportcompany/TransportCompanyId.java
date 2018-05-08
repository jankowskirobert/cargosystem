package eu.jankowskirobert.cargosystem.domain.transportcompany;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
public class TransportCompanyId {
	private String id;
	
	public static TransportCompanyId generate() {
		return of(UUID.randomUUID().toString());
	}
}
