package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.application.cargo.create.NewCargoCommand;
import eu.jankowskirobert.cqrs.CommandExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cargo")
public class CargoHttpApi {

    private CommandExecutor commandExecutor;

    @PostMapping(path = "/new")
    public void addNewCargo(final NewCargoCommand newCargoCommand) {
        commandExecutor.asyncExecutor(newCargoCommand);
    }

}
