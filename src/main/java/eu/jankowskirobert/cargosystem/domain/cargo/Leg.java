package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;

import java.time.LocalDateTime;

public class Leg {
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private Location destination;
    private Location placeOfIssue;
    private Transit transit;
}
