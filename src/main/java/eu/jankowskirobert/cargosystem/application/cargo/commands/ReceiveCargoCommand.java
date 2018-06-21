package eu.jankowskirobert.cargosystem.application.cargo.commands;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceiveCargoCommand {
    private TransportNumber transportNumber;
    private Location reciveLocation;
    private LocalDateTime reciveTime;
}
