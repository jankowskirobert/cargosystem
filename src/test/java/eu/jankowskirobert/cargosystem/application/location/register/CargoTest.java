package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoId;
import eu.jankowskirobert.cargosystem.domain.cargo.RouteSpecification;
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.cargo.delivery.DeliveryStatus;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransitMovement;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.shared.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
public class CargoTest {

    @Mock
    private LocationQueryRepository locationQueryRepository;
    private Address addressS1;
    private Address addressS2;

    @Before
    public void setUp() throws Exception {
        addressS1 = Address.builder().country("GERMANY").build();
        addressS2 = Address.builder().country("ENGLAND").build();
    }

    @Test
    public void testSampleCargoRouting() {
        Cargo cargo = prepareNewCargoFromGermanyToEngland("ID", "TN1");
    }

    @Test
    public void sendCargoToUnavaliableLocationShouldFail() {
        Company company = Company.empty();
        Location sample1 = Location.of(LocationId.of("SAMPLE1"), addressS1, company, LocalDate.now());
        Location sample2 = Location.of(LocationId.of("SAMPLE2"), addressS2, company, LocalDate.now());
        TransitMovement first = TransitMovement.of(sample1, sample2, LocalDateTime.now(), LocalDateTime.now());
        TransitMovement second = TransitMovement.of(sample2, sample1, LocalDateTime.now(), LocalDateTime.now());

        RouteSpecification routeSpecification = RouteSpecification.of(sample1, sample2, LocalDate.now());
        Cargo cargo = Cargo.newEmpty(CargoId.of("Test1"), TransportNumber.random(), routeSpecification);
    }

    @Test
    public void testEmptyCargo() {
        Company company = Company.empty();
        Location sample1 = Location.of(LocationId.of("SAMPLE1"), addressS1, company, LocalDate.now());
        Location sample2 = Location.of(LocationId.of("SAMPLE2"), addressS2, company, LocalDate.now());
        TransitMovement first = TransitMovement.of(sample1, sample2, LocalDateTime.now(), LocalDateTime.now());
        TransitMovement second = TransitMovement.of(sample2, sample1, LocalDateTime.now(), LocalDateTime.now());

        RouteSpecification routeSpecification = RouteSpecification.of(sample1, sample2, LocalDate.now());
        Cargo cargo = Cargo.newEmpty(CargoId.of("Test1"), TransportNumber.random(), routeSpecification);

        Assert.assertTrue(cargo.getDelivery().status().equals(DeliveryStatus.UNKNOWN));

    }

    private Cargo prepareNewCargoFromGermanyToEngland(String id, String number) {
        CargoId cargoId = CargoId.of(id);
        Company company = Company.empty();
        TransportNumber transportNumber = TransportNumber.of(number);
        Address addressS1 = Address.builder().country("GERMANY").build();
        Address addressS2 = Address.builder().country("ENGLAND").build();
        Location sample1 = Location.of(LocationId.of("SAMPLE1"), addressS1, company, LocalDate.now());
        Location sample2 = Location.of(LocationId.of("SAMPLE2"), addressS2, company, LocalDate.now());
        RouteSpecification routeSpecification = RouteSpecification.of(sample1, sample2, LocalDate.now());
        return Cargo.newEmpty(cargoId, transportNumber, routeSpecification);
    }
}
