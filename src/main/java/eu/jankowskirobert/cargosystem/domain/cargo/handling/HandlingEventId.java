package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HandlingEventId {
    private String id;

    public static HandlingEventId random() {
        return new HandlingEventId(UUID.randomUUID().toString());
    }
}
