package eu.jankowskirobert.cargosystem.application.cargo.send;

import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cqrs.infrastructure.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SendCargoToNewLocationCommandHandler implements CommandHandler<SendCargoToNewLocationCommand, Void> {

    private CargoRepository cargoRepository;

    @Override
    public Void handle(SendCargoToNewLocationCommand sendCargoToNewLocationCommand) {
        Cargo cargo = cargoRepository.findFirst(sendCargoToNewLocationCommand.transportNumber());

        return null;
    }
}
