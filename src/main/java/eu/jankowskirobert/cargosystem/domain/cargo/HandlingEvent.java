package eu.jankowskirobert.cargosystem.domain.cargo;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
//@AllArgsConstructor(staticName = "of")
@Getter
public class HandlingEvent {
    private HandlingEventType type;
}
