package eu.jankowskirobert.cargosystem.domain.location;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor(staticName = "of")
public class LocationId {
     @NotNull
     private String id;
}
