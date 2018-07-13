package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
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
        /**
         *
         */
        LOAD, UNLOAD, RECEIVE, CLAIM, REFUSAL, CHECK, UNKNOWN

    }

}
