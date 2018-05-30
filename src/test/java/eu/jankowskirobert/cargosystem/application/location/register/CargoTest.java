package eu.jankowskirobert.cargosystem.application.location.register;

import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Schedule;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransitId;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransitMovement;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationQueryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class CargoTest {

    @Autowired
    private LocationQueryRepository locationQueryRepository;

    @Test
    public void testSampleCargoRouting() {
        Location sample1 = locationQueryRepository.find(LocationId.of("SAMPLE1"));
        Location sample2 = locationQueryRepository.find(LocationId.of("SAMPLE2"));
        TransitMovement first = TransitMovement.of(sample1, sample2, LocalDateTime.now(), LocalDateTime.now());
        TransitMovement second = TransitMovement.of(sample2, sample1, LocalDateTime.now(), LocalDateTime.now());
        Transit transit = Transit.of(TransitId.of("0123"), Schedule.of(first, second));
        RouteSpecification route = RouteSpecification.of(sample1, sample2, LocalDate.now());
        Itinerary itinerary = Itinerary.empty();
        Cargo cargoConstruction = Cargo.of(CargoId.of("XYZ"), TransportNumber.random(), route, itinerary);
    }
}
