package eu.jankowskirobert.cargosystem.application.cargo.handlers;

import eu.jankowskirobert.cargosystem.application.cargo.commands.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.application.cargo.events.RegisterCargoEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
/*
TODO: [bsc info] remove
This command handler represents behaviour behind cargo registration:
1. Generate cargo id,
2. Set up route specification
3. Set up empty itinerary
4. build basic cargo domain object with empty history and transit schedule
5. Save domain object, produce event to add cargo to query node as projection (not business event, just internal)
 */
/**
 *
 */
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
