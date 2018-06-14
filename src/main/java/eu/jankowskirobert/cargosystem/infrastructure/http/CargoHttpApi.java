package eu.jankowskirobert.cargosystem.infrastructure.http;

import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommand;
import eu.jankowskirobert.cargosystem.application.cargo.register.RegisterCargoCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
