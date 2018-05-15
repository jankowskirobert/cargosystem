package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.location.Location;

import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private Location destination;
    private Location placeOfIssue;
}
