package eu.jankowskirobert.cargosystem.domain.transportcompany;

import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder()
public class TransportCompany {
	private TransportCompanyId id;
	private String name;
	private Address companyLocationAddress;
	
}
