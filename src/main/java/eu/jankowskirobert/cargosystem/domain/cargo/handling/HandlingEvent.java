package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.TransportNumber;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Objects;

/*
 * Event that will update main aggregate root node through handling service
 */
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class HandlingEvent {
    private HandlingEventId id;
    private HandlingType type;
    private LocalDateTime eventRegistration;
    private LocalDateTime eventCompetition;
    private TransportNumber transportNumber;
    private Transit transit;
    private Location location;


    public static HandlingEvent registerOnCreate(HandlingEventId id, HandlingType type, TransportNumber transportNumber, Location location) {
        if(type.isTransitRequired()){
            throw new IllegalArgumentException();
        }
        return new HandlingEvent(id, type, LocalDateTime.now(), null, transportNumber, null, location);
    }

    public static HandlingEvent registerOnCreate(HandlingEventId id, HandlingType type, TransportNumber transportNumber, Transit transit, Location location) {
        if(!type.isTransitRequired()){
            throw new IllegalArgumentException();
        }
        return new HandlingEvent(id, type, LocalDateTime.now(), null, transportNumber, transit, location);
    }

    public static HandlingEvent of(HandlingEventId id, HandlingType type, LocalDateTime eventRegistration, LocalDateTime eventCompetition, TransportNumber transportNumber, Transit transit, Location location) {
        return new HandlingEvent(id, type, eventRegistration, eventCompetition, transportNumber, transit, location);
    }

    public boolean eventNotComplete() {
        return Objects.isNull(eventCompetition);
    }

    public void markAsComplete(){
        eventCompetition = LocalDateTime.now();
    }

    public void markAsComplete(LocalDateTime eventCompetition){
        this.eventCompetition = eventCompetition;
    }
}

