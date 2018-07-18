package eu.jankowskirobert.cargosystem.domain.cargo.handling;

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
    private HandlingType type;
    private Location location;
}
