package eu.jankowskirobert.cargosystem.domain.location;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = "id")
@Getter
public class LocationId {
     @NotNull
     private String id;

    public static LocationId random() {
        return new LocationId(UUID.randomUUID().toString());
    }
}
