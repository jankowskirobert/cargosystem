package eu.jankowskirobert.cargosystem.application.cargo.commands;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
@Getter
public class RegisterCargoCommand {
    private TransportNumber transportNumber;
    private String name;
    private Location locationFrom;
    private Location locationTo;
    private LocalDate arrival;
}
