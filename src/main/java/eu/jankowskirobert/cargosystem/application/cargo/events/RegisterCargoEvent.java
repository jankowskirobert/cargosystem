package eu.jankowskirobert.cargosystem.application.cargo.events;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import org.springframework.context.ApplicationEvent;

public class RegisterCargoEvent extends ApplicationEvent {

    private TransportNumber transportNumber;

    public RegisterCargoEvent(Object source, TransportNumber transportNumber) {
        super(source);
        this.transportNumber = transportNumber;
    }

}
