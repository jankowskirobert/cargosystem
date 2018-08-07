package eu.jankowskirobert.cargosystem.application.cargo.events;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;

@AllArgsConstructor(staticName = "of")
public class RegisterEventHandler implements ApplicationListener<RegisterCargoEvent> {



    @Override
    public void onApplicationEvent(RegisterCargoEvent registerCargoEvent) {

    }
}
