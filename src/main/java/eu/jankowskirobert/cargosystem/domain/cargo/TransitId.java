package eu.jankowskirobert.cargosystem.domain.cargo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
@EqualsAndHashCode(of = "id")
public class TransitId {
    private String id;
}
