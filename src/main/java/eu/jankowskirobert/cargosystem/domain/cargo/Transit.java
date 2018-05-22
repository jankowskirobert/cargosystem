package eu.jankowskirobert.cargosystem.domain.cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class Transit {

    private TransitId id;
    private Schedule schedule;
}
