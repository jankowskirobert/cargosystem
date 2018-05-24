package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;

@Accessors(fluent = true)
@Getter
@AllArgsConstructor(staticName = "of")
public class HandlingHistory {

    private final List<HandlingEvent> history = Collections.EMPTY_LIST;

    public static HandlingHistory empty() {
        return new HandlingHistory();
    }
}
