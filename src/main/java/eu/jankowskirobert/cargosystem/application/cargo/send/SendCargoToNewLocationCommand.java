package eu.jankowskirobert.cargosystem.application.cargo.send;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SendCargoToNewLocationCommand {
    private TransportNumber transportNumber;
}
