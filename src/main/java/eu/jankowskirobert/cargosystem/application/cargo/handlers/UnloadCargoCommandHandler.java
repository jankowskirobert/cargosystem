package eu.jankowskirobert.cargosystem.application.cargo.handlers;

import eu.jankowskirobert.cargosystem.application.cargo.commands.UnloadCargoCommand;
import eu.jankowskirobert.cargosystem.infrastructure.cqrs.CommandHandler;

public class UnloadCargoCommandHandler implements CommandHandler<UnloadCargoCommand, String> {
    @Override
    public String handle(UnloadCargoCommand unloadCargoCommand) {
        return null;
    }
}
