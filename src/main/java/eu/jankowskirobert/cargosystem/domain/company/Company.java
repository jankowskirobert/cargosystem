package eu.jankowskirobert.cargosystem.domain.company;

import eu.jankowskirobert.cargosystem.shared.Continent;
import lombok.*;

import java.util.Set;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Company {
	private CompanyId companyId;
	private String name;
	private Set<Continent> available;
	private String websiteAddress;
	private String phoneNumber;
	private Set<CompanyType> types;
	private Set<String> otherTypes;

	public static Company empty(){
		return new Company();
	}
}
