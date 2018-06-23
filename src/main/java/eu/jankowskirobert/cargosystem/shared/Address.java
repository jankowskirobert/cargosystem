package eu.jankowskirobert.cargosystem.shared;

import lombok.*;

@AllArgsConstructor(staticName = "of",access = AccessLevel.PUBLIC)
@Getter
@Builder
@NoArgsConstructor
public class Address {
	private String street;
	private String zipCode;
	private String state;
	private String region;
	private String country;
	private Continent continent;

}
