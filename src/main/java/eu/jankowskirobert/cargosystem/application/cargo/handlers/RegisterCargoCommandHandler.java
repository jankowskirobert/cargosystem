package eu.jankowskirobert.cargosystem.application.cargo.handlers;

import eu.jankowskirobert.cargosystem.application.cargo.commands.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.application.cargo.events.RegisterCargoEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCargoCommandHandler implements CommandHandler<RegisterCargoCommand, Void> {

    private CargoRepository cargoRepository;
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Void handle(RegisterCargoCommand registerCargoCommand) {
        CargoId cargoId = CargoId.random();
        RouteSpecification routeSpecification = RouteSpecification.of(registerCargoCommand.getLocationFrom(), registerCargoCommand.getLocationTo(), registerCargoCommand.getArrival());
        Itinerary itinerary = Itinerary.empty();
        TransportNumber transportNumber = registerCargoCommand.getTransportNumber();
        Cargo newCargo = Cargo.of(cargoId, transportNumber, routeSpecification, itinerary);
        publishCargoEvent(transportNumber);
        cargoRepository.store(newCargo);
        return null;
    }

    private void publishCargoEvent(TransportNumber transportNumber) {
        RegisterCargoEvent registerCargoEvent = new RegisterCargoEvent(this, transportNumber);
        applicationEventPublisher.publishEvent(registerCargoEvent);
    }
}
