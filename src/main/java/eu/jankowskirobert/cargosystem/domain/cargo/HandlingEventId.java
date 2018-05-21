package eu.jankowskirobert.cargosystem.domain.cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class HandlingEventId {
    private String id;
}
