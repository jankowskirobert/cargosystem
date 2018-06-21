package eu.jankowskirobert.cargosystem.application.cargo.handlers;

import eu.jankowskirobert.cargosystem.application.cargo.commands.ReceiveCargoCommand;
import eu.jankowskirobert.cargosystem.domain.cargo.Cargo;
import eu.jankowskirobert.cargosystem.domain.cargo.CargoRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingActivity;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventId;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventRepository;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceiveCargoCommandHandler implements CommandHandler<ReceiveCargoCommand, HandlingEventId> {

    private CargoRepository cargoRepository;
    private HandlingEventRepository handlingEventRepository;

    @Override
    public HandlingEventId handle(ReceiveCargoCommand receiveCargoCommand) {
        Cargo cargo = cargoRepository.findFirst(receiveCargoCommand.transportNumber());
        HandlingEventId handlingEventId = HandlingEventId.random();
        HandlingEvent handlingEvent = HandlingEvent.of(handlingEventId, HandlingActivity.Type.RECEIVE, cargo, receiveCargoCommand.reciveTime(), receiveCargoCommand.reciveLocation());
        handlingEventRepository.store(handlingEvent);
        return handlingEventId;
    }
}
