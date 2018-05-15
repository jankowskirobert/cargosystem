package eu.jankowskirobert.cargosystem.domain.company;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Company {
	private CompanyId companyId;
	private String name;

	public static Company empty(){
		return new Company(null, null);
	}
}
