package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class RouteSpecification {
    @Getter()
    private Location origin;
    private Location destination;
    private LocalDateTime arrivalDeadline;
}
