package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.domain.cargo.delivery.DeliveryStatus;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransportFutureDecision;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransportStatusDecision;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/*

 */
@AllArgsConstructor(staticName = "of")
@Accessors(fluent = true)
@Getter
public class HandlingActivity {
    private Type type;
    private Transit transit;
    private Location location;

    public enum Type {
        LOAD, UNLOAD, RECEIVE, CLAIM, CHECK, UNKNOWN
    }

}
