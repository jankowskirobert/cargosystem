package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.domain.transportcompany.TransportCompany;
import lombok.Getter;

import java.time.LocalDateTime;
/*
Road transport leg
Etap transportu drogowego
 */
@Getter
public class Leg {
    private LocalDateTime load;
    private LocalDateTime unload;
    private Location loadLocation;
    private Location unloadLocation;
    private Transit transit;


}
