package eu.jankowskirobert.cargosystem.domain.cargo.transit;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Accessors(fluent = true)
public class TransitMovement {
    private Location from;
    private Location to;
    private LocalDateTime departure;
    private LocalDateTime arrival;
}
