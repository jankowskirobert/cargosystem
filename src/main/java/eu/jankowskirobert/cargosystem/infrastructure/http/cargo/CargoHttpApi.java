package eu.jankowskirobert.cargosystem.infrastructure.http.cargo;

import eu.jankowskirobert.cargosystem.application.cargo.commands.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.application.cargo.handlers.RegisterCargoCommandHandler;
import eu.jankowskirobert.cargosystem.composite.cargo.RegisterCargoCommandFactory;
import eu.jankowskirobert.cargosystem.composite.cargo.RegisterCargoDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor(staticName = "of")
@RestController("/cargo")
public class CargoHttpApi {
    private RegisterCargoCommandHandler registerCargoCommandHandler;
    private RegisterCargoCommandFactory registerCargoCommandFactory;

    @PostMapping(path = "/register")
    public String registerCargo(final RegisterCargoDTO registerCargoDTO) {
        RegisterCargoCommand registerCargoCommand = registerCargoCommandFactory.cargo(registerCargoDTO);
        registerCargoCommandHandler.handle(registerCargoCommand);
        return registerCargoCommand.getTransportNumber().getNumber();
    }

}
