package eu.jankowskirobert.cargosystem.application.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEvent;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventId;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEventRepository;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingType;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import eu.jankowskirobert.cargosystem.infrastructure.configuration.SpringAMQPConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@AllArgsConstructor(staticName = "of")
public class HandlingService implements HandlingEventService {

    private HandlingEventRepository handlingEventRepository;

    @Override
    public HandlingEventStatus checkEvent(HandlingEventId id) {
        return null;
    }

    @Override
    public HandlingEventId registerEvent(HandlingType type, TransportNumber transportNumber, Location location) {
        HandlingEventId handlingEventId = HandlingEventId.random();
        HandlingEvent handlingEvent = HandlingEvent.registerOnCreate(handlingEventId, type, transportNumber, location);
        handlingEventRepository.store(handlingEvent);
        return handlingEventId;
    }

    @Override
    public HandlingEventId registerEvent(HandlingType type, TransportNumber transportNumber, Transit transit, Location location) {
        HandlingEventId handlingEventId = HandlingEventId.random();
        HandlingEvent handlingEvent = HandlingEvent.registerOnCreate(handlingEventId, type, transportNumber, transit, location);
        handlingEventRepository.store(handlingEvent);
        return handlingEventId;
    }

    @Override
    public void handleCargoEvent(HandlingEvent event) {


        handlingEventRepository.store(event);
    }

    @RabbitListener(queues = {SpringAMQPConfig.handlingQueue})
    public void receiveMessageFromFanout1(String message) {
        log.info("[Q] - {}", message);
    }


}
