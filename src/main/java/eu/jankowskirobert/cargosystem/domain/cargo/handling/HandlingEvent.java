package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoId;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/*
 * Event that will update main aggregate root node
 */
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
@Getter
public class HandlingEvent {
    private HandlingEventId id;
    private HandlingActivity activity;
    private LocalDateTime eventRegistration;
    private LocalDateTime eventCompetition;
    private CargoId cargoId;

    public static HandlingEvent of(HandlingEventId handlingEventId, HandlingActivity.Type receive, Cargo cargo, LocalDateTime eventCompetition, Location location) {
        return null;
    }
}

