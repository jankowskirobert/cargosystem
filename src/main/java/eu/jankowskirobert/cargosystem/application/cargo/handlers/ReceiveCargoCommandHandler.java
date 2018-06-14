package eu.jankowskirobert.cargosystem.application.cargo.handlers;

import eu.jankowskirobert.cargosystem.application.cargo.commands.ReceiveCargoCommand;
import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceiveCargoCommandHandler implements CommandHandler<ReceiveCargoCommand, Void> {

    private CargoRepository cargoRepository;

    @Override
    public Void handle(ReceiveCargoCommand receiveCargoCommand) {
        Cargo cargo = cargoRepository.findFirst(receiveCargoCommand.transportNumber());

        return null;
    }
}
