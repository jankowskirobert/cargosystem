package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Delivery {
    private DeliveryStatus deliveryStatus;
    private Location lastLocation;
    private Transit current;
    private LocalDateTime estimatedTimeOfArrival;
    private HandlingActivity handlingActivity;
    private RoutingStatus routingStatus;
    private HandlingEvent handlingEvent;

    public static Delivery of(RouteSpecification routeSpecification, Itinerary itinerary){
        return new Delivery(new HandlingEvent(), routeSpecification, itinerary);
    }

    public Delivery(HandlingEvent event, RouteSpecification routeSpecification, Itinerary itinerary){
        this.deliveryStatus = this.matchDeliveryStatus(event);
        this.lastLocation = this.dispatchLocationFromEvent(event);
        this.current = this.dispatchTransitFromEvent(event);
        this.estimatedTimeOfArrival = this.estimate(itinerary);
    }

    private LocalDateTime estimate(Itinerary itinerary) {
        return itinerary.getFinalArrival();
    }

    private Transit dispatchTransitFromEvent(HandlingEvent event) {
        return event.transit();
    }

    private Location dispatchLocationFromEvent(HandlingEvent event) {
        return event.location();
    }

    private DeliveryStatus matchDeliveryStatus(HandlingEvent event) {
        if(!Objects.isNull(event)){
            switch (event.type()){
                case LOAD:
                    return DeliveryStatus.ON_THE_WAY;
                case UNLOAD:
                    return DeliveryStatus.IN_MAGAZINE;
                case RECEIVE:
                    return DeliveryStatus.TRANSFERED;
                case CLAIM:
                    return DeliveryStatus.WAITING;
                default:
                    return DeliveryStatus.UNKNOWN;
            }
        }
        return DeliveryStatus.UNKNOWN;
    }
}
