package eu.jankowskirobert.cargosystem.domain.cargo;

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
}

