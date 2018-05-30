package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommandHandler;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.shared.Address;
import eu.jankowskirobert.cargosystem.shared.Continent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class CargoHandlerTest {
    @Autowired
    private CargoRepository cargoRepository;

    @Test
    public void shouldCreateNewCargo() {
        Address address = Address.of("", "", "", "", "", Continent.EUROPE);
        CompanyId companyId = CompanyId.of("001");
        Company company = Company.empty();
        LocationId locationIdF = LocationId.of("001");
        LocationId locationIdT = LocationId.of("002");
        Location from = Location.of(locationIdF,address,company, LocalDate.now());
        Location to = Location.of(locationIdT,address,company, LocalDate.now());
        //given
        RegisterCargoCommand newCargo = RegisterCargoCommand.of(TransportNumber.random(), "Fridge", from, to, LocalDate.now());
        RegisterCargoCommandHandler handler = RegisterCargoCommandHandler.of(cargoRepository);
        //when
        handler.handle(newCargo);
        //then
        Assert.assertNotNull(cargoRepository.findFirst(TransportNumber.of("123")));
    }
}
