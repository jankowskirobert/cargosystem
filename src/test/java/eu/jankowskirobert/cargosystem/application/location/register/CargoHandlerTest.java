package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommandHandler;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.company.CompanyId;
import eu.jankowskirobert.cargosystem.domain.company.CompanyRepository;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyId;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompanyRepository;
import eu.jankowskirobert.cargosystem.shared.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class CargoHandlerTest {
    @Autowired
    private LocationQueryRepository locationQueryRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TransportCompanyRepository transportCompanyRepository;
    @Autowired
    private CargoRepository cargoRepository;

    @Before
    public void setUp() {
        Address address = Address.of("", "", "", "", "");
        CompanyId companyId = CompanyId.of("001");
        Company company = Company.of(companyId, "BANK");
        companyRepository.store(company);

        TransportCompanyId transportCompanyId = TransportCompanyId.of("001");
        TransportCompany transportCompany = TransportCompany.of(transportCompanyId, "CIT", address);
        transportCompanyRepository.store(transportCompany);

        LocationId locationIdF = LocationId.of("001");
        LocationId locationIdT = LocationId.of("002");
        Location from = Location.of(locationIdF,address,companyId, LocalDate.now());
        Location to = Location.of(locationIdT,address,companyId, LocalDate.now());


        locationQueryRepository.store(from);
        locationQueryRepository.store(to);

    }

    @Test
    public void shouldCreateNewCargo() {
        //given
        RegisterCargoCommand newCargo = RegisterCargoCommand.of("123", "Fridge", BigDecimal.TEN, "001", "001", "001","002",  LocalDate.now());
        RegisterCargoCommandHandler handler = RegisterCargoCommandHandler.of(cargoRepository, companyRepository, transportCompanyRepository, locationQueryRepository);
        //when
        handler.handle(newCargo);
        //then
        Assert.assertNotNull(cargoRepository.findFirst(TransportNumber.of("123")));
    }
}
