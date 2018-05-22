package eu.jankowskirobert.cargosystem.domain.cargo;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
@Getter
public class TransportNumber {
    private String number;

    public static TransportNumber random() {
        return new TransportNumber(UUID.randomUUID().toString());
    }
}
