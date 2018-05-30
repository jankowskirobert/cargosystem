package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepositoryException;
import eu.jankowskirobert.cargosystem.shared.Address;
import eu.jankowskirobert.cargosystem.shared.Continent;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class LocationHandlerTest {

	@Autowired
	private LocationQueryRepository locationQueryRepository;
	@Autowired
	private CompanyRepository companyRepository;
	private RegisterLocationCommandHandler registerLocationCommandHandler;
    private final String companyId = "001";
	@Before
	public void setUp() {
		registerLocationCommandHandler = new RegisterLocationCommandHandler(locationQueryRepository);
	}
	
	@Test
	public void shouldCreateNewLocation() {
		Company company = Company.empty();
		Address address = Address.of("", "", "", "", "", Continent.EUROPE);
        LocalDate now = LocalDate.now();
        RegisterLocationCommand command = RegisterLocationCommand.of(address, company, now);
		registerLocationCommandHandler.handle(command);
		String id = "T1";
		Location xxx = Location.of(LocationId.of(id),address, company, now);
        Assert.assertThat(locationQueryRepository.find(LocationId.of(id)), Matchers.equalTo(xxx));
	}

    @Test(expected = LocationRepositoryException.class)
    public void shouldCreateNewLocation_secondStoreThrowException() {
        Company company = Company.empty();
        Address address = Address.of("", "", "", "", "", Continent.EUROPE);
        LocalDate now = LocalDate.now();
        RegisterLocationCommand command = RegisterLocationCommand.of(address, company, now);
        registerLocationCommandHandler.handle(command);
        registerLocationCommandHandler.handle(command);
    }

}