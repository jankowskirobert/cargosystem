package eu.jankowskirobert.cargosystem.domain.company;

import eu.jankowskirobert.cargosystem.shared.Continent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Company {
	private CompanyId companyId;
	private String name;
	private Set<Continent> available;

	public static Company empty(){
		return new Company(null, null, null);
	}
}
