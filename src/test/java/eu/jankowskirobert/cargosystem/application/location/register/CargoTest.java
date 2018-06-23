package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.composite.location.LocationQueryRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoId;
import eu.jankowskirobert.cargosystem.domain.cargo.RouteSpecification;
import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Schedule;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransitId;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransitMovement;
import eu.jankowskirobert.cargosystem.domain.company.Company;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.shared.Address;
import eu.jankowskirobert.cargosystem.shared.Continent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
public class CargoTest {

    @Mock
    private LocationQueryRepository locationQueryRepository;

    @Test
    public void testSampleCargoRouting() {
        Address addressS1 = Address.of("SAMPLE1", "SAMPLE1", "SAMPLE1", "SAMPLE1", "SAMPLE1", Continent.EUROPE);
        Address addressS2 = Address.of("SAMPLE2", "SAMPLE2", "SAMPLE2", "SAMPLE2", "SAMPLE2", Continent.EUROPE);
        Company company = Company.empty();
        Location sample1 = Location.of(LocationId.of("SAMPLE1"), addressS1, company, LocalDate.now());
        Location sample2 = Location.of(LocationId.of("SAMPLE2"), addressS2, company, LocalDate.now());
        TransitMovement first = TransitMovement.of(sample1, sample2, LocalDateTime.now(), LocalDateTime.now());
        TransitMovement second = TransitMovement.of(sample2, sample1, LocalDateTime.now(), LocalDateTime.now());
        Transit transit = Transit.of(TransitId.of("0123"), Schedule.of(first, second));
        RouteSpecification routeSpecification = RouteSpecification.of(sample1, sample2, LocalDate.now());
        Cargo cargo = Cargo.newEmpty(CargoId.of("Test1"), TransportNumber.random(), routeSpecification);
    }
}
