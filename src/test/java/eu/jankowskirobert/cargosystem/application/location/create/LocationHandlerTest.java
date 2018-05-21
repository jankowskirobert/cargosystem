package eu.jankowskirobert.cargosystem.application.location.create;

import java.time.LocalDate;
import java.time.LocalDateTime;

import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepositoryException;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import eu.jankowskirobert.cargosystem.shared.Address;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class LocationHandlerTest {

	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private CompanyRepository companyRepository;
	private NewLocationCommandHandler newLocationCommandHandler;
    private final String companyId = "001";
	@Before
	public void setUp() {
		newLocationCommandHandler = new NewLocationCommandHandler(locationRepository, companyRepository);
        CompanyId id = CompanyId.of(companyId);
		Company company = Company.of(id, "BANK");
		companyRepository.store(company);
	}
	
	@Test
	public void shouldCreateNewLocation() {
		Address address = Address.of("", "", "", "", "");
        LocalDate now = LocalDate.now();
        String id = "123";
        NewLocationCommand command = NewLocationCommand.of(id, address, companyId, now);
		newLocationCommandHandler.handle(command);
		Location xxx = Location.of(LocationId.of(id),address, CompanyId.of(companyId), now);
        Assert.assertThat(locationRepository.find(LocationId.of(id)), Matchers.equalTo(xxx));
	}

    @Test(expected = LocationRepositoryException.class)
    public void shouldCreateNewLocation_secondStoreThrowException() {
        Address address = Address.of("", "", "", "", "");
        LocalDate now = LocalDate.now();
        String id = "123";
        NewLocationCommand command = NewLocationCommand.of(id, address, companyId, now);
        newLocationCommandHandler.handle(command);
        newLocationCommandHandler.handle(command);
    }

}
