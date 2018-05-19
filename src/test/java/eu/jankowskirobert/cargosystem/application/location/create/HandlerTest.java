package eu.jankowskirobert.cargosystem.application.location.create;

import java.time.LocalDate;
import java.time.LocalDateTime;

import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import org.junit.Before;
import org.junit.Test;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.shared.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TestConfiguration.class})
public class HandlerTest {

	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private CompanyRepository companyRepository;
	private NewLocationCommandHandler newLocationCommandHandler;
	
	@Before
	public void setUp() {
		newLocationCommandHandler = new NewLocationCommandHandler(locationRepository, companyRepository);
	}
	
	@Test
	public void shouldCreateNewLocation() {
		Address address = Address.of("", "", "", "", "");
		NewLocationCommand command = NewLocationCommand.of("", address, "z", LocalDate.now());
		newLocationCommandHandler.handle(command);
	}
}
