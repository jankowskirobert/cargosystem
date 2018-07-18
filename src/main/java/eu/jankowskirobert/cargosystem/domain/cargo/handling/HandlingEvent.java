package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/*
 * Event that will update main aggregate root node through handling service
 */
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
@Getter
public class HandlingEvent {
    private HandlingEventId id;
    private HandlingType type;
    private LocalDateTime eventRegistration;
    private LocalDateTime eventCompetition;
    private Cargo cargo;
    private Transit transit;
    private Location location;


}

