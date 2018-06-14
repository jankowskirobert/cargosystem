package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepositoryException;
import eu.jankowskirobert.cargosystem.domain.location.LocationWriteRepository;
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
import java.util.UUID;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class LocationHandlerTest {

	@Autowired
	private LocationQueryRepository locationQueryRepository;
	@Autowired
	private LocationWriteRepository locationWriteRepository;

	private RegisterLocationCommandHandler registerLocationCommandHandler;
    private final String companyId = "001";
	@Before
	public void setUp() {
		registerLocationCommandHandler = RegisterLocationCommandHandler.of(locationWriteRepository);
	}
	
	@Test
	public void shouldCreateNewLocation() {
		String id = UUID.randomUUID().toString();
		Company company = Company.empty();
		Address address = Address.of("", "", "", "", "", Continent.EUROPE);
        LocalDate now = LocalDate.now();
        RegisterLocationCommand command = RegisterLocationCommand.of(LocationId.of(id), address, company, now);
		registerLocationCommandHandler.handle(command);
		Location xxx = Location.of(LocationId.of(id),address, company, now);
        Assert.assertThat(locationQueryRepository.find(LocationId.of(id)), Matchers.equalTo(xxx));
	}

    @Test(expected = LocationRepositoryException.class)
    public void shouldCreateNewLocation_secondStoreThrowException() {
        String id = UUID.randomUUID().toString();
        Company company = Company.empty();
        Address address = Address.of("", "", "", "", "", Continent.EUROPE);
        LocalDate now = LocalDate.now();
        RegisterLocationCommand command = RegisterLocationCommand.of(LocationId.of(id),address, company, now);
        registerLocationCommandHandler.handle(command);
        registerLocationCommandHandler.handle(command);
    }

}
