package eu.jankowskirobert.cargosystem.application.cargo.handlers;

import eu.jankowskirobert.cargosystem.application.cargo.commands.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterCargoCommandHandler implements CommandHandler<RegisterCargoCommand, Void> {

    private CargoRepository cargoRepository;

    @Override
    public Void handle(RegisterCargoCommand registerCargoCommand) {
        CargoId cargoId = CargoId.random();
        RouteSpecification routeSpecification = RouteSpecification.of(registerCargoCommand.getLocationFrom(), registerCargoCommand.getLocationTo(), registerCargoCommand.getArrival());
        Itinerary itinerary = Itinerary.empty();
        Cargo newCargo = Cargo.of(cargoId, registerCargoCommand.getTransportNumber(), routeSpecification, itinerary);
        cargoRepository.store(newCargo);
        return null;
    }
}
