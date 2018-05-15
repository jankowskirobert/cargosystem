package eu.jankowskirobert.cargosystem.domain.transportcompany;

import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.*;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder()
public class TransportCompany {
	private TransportCompanyId id;
	private String name;
	private Address companyLocationAddress;

	public static TransportCompany empty(){
	    return new TransportCompany(TransportCompanyId.builder().build(), "", Address.builder().build());
    }
}
