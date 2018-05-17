package eu.jankowskirobert.cargosystem.application.location.create;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.shared.Address;

public class HandlerTest {
	
	private LocationRepository locationRepository;
	private CompanyRepository companyRepository;
	private NewLocationCommandHandler newLocationCommandHandler;
	
	@Before
	public void setUp() {
		locationRepository = new LocationRepository() {
			
			@Override
			public void store(Location newLocation) {
				
			}
		};
		companyRepository = new CompanyRepository() {
			
			@Override
			public Company find(CompanyId companyId) {
				return Company.of(companyId, null);
			}
		};
		newLocationCommandHandler = new NewLocationCommandHandler(locationRepository, companyRepository);
	}
	
	@Test
	public void shouldCreateNewLocation() {
		Address address = Address.of("", "", "", "", "");
		NewLocationCommand command = NewLocationCommand.builder().address(address).availability(LocalDate.now()).companyId("x").build();
		newLocationCommandHandler.handle(command);
	}
}
