package eu.jankowskirobert.cargosystem.domain.cargo;

import java.math.BigDecimal;
import java.util.List;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;

public class Cargo {
	private CargoId id;
	private TransportCompany transportCompany;
	private Location placeOfForwarding;
	private String name;
	private BigDecimal weight;
	private List<DeliveryHistory> deliveryHistory;
	
	public void apply(final List<DeliveryHistory> history) {
		for(DeliveryHistory historyElement : history) {
			
		}
	}
}
