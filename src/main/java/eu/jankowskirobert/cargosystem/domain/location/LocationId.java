package eu.jankowskirobert.cargosystem.domain.location;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = "of")
public class LocationId {
     @NotNull
     private String id;
}
