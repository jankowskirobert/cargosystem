package eu.jankowskirobert.cargosystem.application.cargo.handlers;

import eu.jankowskirobert.cargosystem.application.cargo.commands.ReceiveCargoCommand;
import eu.jankowskirobert.cargosystem.application.handling.HandlingEventService;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventId;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingType;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceiveCargoCommandHandler implements CommandHandler<ReceiveCargoCommand, HandlingEventId> {

    private CargoRepository cargoRepository;
    private HandlingEventService handlingEventService;

    @Override
    public HandlingEventId handle(ReceiveCargoCommand receiveCargoCommand) {
        HandlingEventId handlingEventId=handlingEventService.registerEvent(HandlingType.RECEIVE, receiveCargoCommand.transportNumber(), receiveCargoCommand.reciveLocation());
        return handlingEventId;
    }
}
