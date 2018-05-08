package eu.jankowskirobert.cargosystem.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder
public class Address {
	private String street;
	private String zipCode;
	private String state;
	private String region;
	private String country;
}
