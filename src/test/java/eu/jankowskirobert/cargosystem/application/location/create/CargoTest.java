package eu.jankowskirobert.cargosystem.application.location.create;

import eu.jankowskirobert.cargosystem.domain.cargo.Schedule;
import eu.jankowskirobert.cargosystem.domain.cargo.Transit;
import eu.jankowskirobert.cargosystem.domain.cargo.TransitId;
import eu.jankowskirobert.cargosystem.domain.cargo.TransitMovement;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.location.LocationId;
import eu.jankowskirobert.cargosystem.domain.location.LocationRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CargoTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void testSampleCargoRouting() {
        Location sample1 = locationRepository.find(LocationId.of("SAMPLE1"));
        Location sample2 = locationRepository.find(LocationId.of("SAMPLE2"));
        TransitMovement first = TransitMovement.of(sample1, sample2, LocalDateTime.now(), LocalDateTime.now());
        TransitMovement second= TransitMovement.of(sample2, sample1, LocalDateTime.now(), LocalDateTime.now());
        Transit transit = Transit.of(TransitId.of("0123"), Schedule.of(first, second));
    }
}
