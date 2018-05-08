package eu.jankowskirobert.cargosystem.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
public class ContactInfo {
	private String email;
	private String phone;
}
