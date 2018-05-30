package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommand;
import eu.jankowskirobert.cqrs.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cargo")
public class CargoHttpApi {
    @Autowired
    private CommandExecutor commandExecutor;
    private RegisterCargoCommandFactory registerCargoCommandFactory;

    @PostMapping(path = "/new")
    public String registerCargo(final RegisterCargoDTO registerCargoDTO) {
        RegisterCargoCommand registerCargoCommand = registerCargoCommandFactory.cargo(registerCargoDTO);
        commandExecutor.asyncExecutor(registerCargoCommand);
        return registerCargoCommand.getTransportNumber().getNumber();
    }

}
