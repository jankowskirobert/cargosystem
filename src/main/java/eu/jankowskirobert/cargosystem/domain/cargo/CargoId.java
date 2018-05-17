package eu.jankowskirobert.cargosystem.domain.cargo;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
public class CargoId {
	private String id;
	
	public static CargoId random() {
		return of(UUID.randomUUID().toString());
	}
}
