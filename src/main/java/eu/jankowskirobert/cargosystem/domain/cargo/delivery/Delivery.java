package eu.jankowskirobert.cargosystem.domain.cargo.delivery;

import eu.jankowskirobert.cargosystem.domain.cargo.Itinerary;
import eu.jankowskirobert.cargosystem.domain.cargo.RouteSpecification;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingActivity;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingHistory;
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
    current cargo state
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Delivery {
    private DeliveryStatus status;
    private Location lastLocation;
    private Transit current;
    private LocalDateTime estimatedTimeOfArrival;
    private HandlingActivity.Type[] nextActivityType;
    private RoutingStatus routingStatus;
    private HandlingActivity handlingEvent;

    public static Delivery of(HandlingActivity event, RouteSpecification routeSpecification, Itinerary itinerary) {
        return new Delivery(event, routeSpecification, itinerary);
    }

    public static Delivery of(RouteSpecification routeSpecification, Itinerary itinerary, HandlingHistory history) {
        HandlingActivity last = history.getLastActivity();
        return new Delivery(last, routeSpecification, itinerary);
    }

    private Delivery(HandlingActivity event, RouteSpecification routeSpecification, Itinerary itinerary) {
        this.handlingEvent = event;
        this.status = this.matchDeliveryStatus(event);
        this.lastLocation = this.dispatchLocationFromEvent(event);
        this.current = this.dispatchTransitFromEvent(event);
        this.nextActivityType = this.nextPossibleAction(event);
        this.estimatedTimeOfArrival = this.estimate(itinerary);
        this.lastLocation = routeSpecification.origin();
        this.routingStatus = RoutingStatus.NOT_ROUTED;
    }


    private HandlingActivity.Type[] nextPossibleAction(HandlingActivity activity) {
        if (!Objects.isNull(activity))
            switch (activity.type()) {
                case LOAD: {
                    return new HandlingActivity.Type[]{HandlingActivity.Type.UNLOAD, HandlingActivity.Type.CHECK};
                }
                case UNLOAD: {
                    return new HandlingActivity.Type[]{HandlingActivity.Type.UNLOAD, HandlingActivity.Type.CHECK};
                }
                case RECEIVE: {
                    return new HandlingActivity.Type[]{HandlingActivity.Type.CHECK, HandlingActivity.Type.LOAD, HandlingActivity.Type.CLAIM};
                }
                default:
                    return new HandlingActivity.Type[]{HandlingActivity.Type.UNKNOWN};
            }
        else
            return new HandlingActivity.Type[]{};
    }

    private LocalDateTime estimate(Itinerary itinerary) {
        return itinerary.getFinalArrival();
    }

    private Transit dispatchTransitFromEvent(HandlingActivity activity) {
        if (!Objects.isNull(activity))
            return activity.transit();
        return null;
    }

    private Location dispatchLocationFromEvent(HandlingActivity activity) {
        if (!Objects.isNull(activity))
            return activity.location();
        return null;
    }

    private DeliveryStatus matchDeliveryStatus(HandlingActivity activity) {
        if (!Objects.isNull(activity))
            switch (activity.type()) {
                case LOAD:
                    return DeliveryStatus.ON_THE_WAY;
                case CLAIM:
                    return DeliveryStatus.CLAIMED;
                case REFUSE:
                    return DeliveryStatus.REFUSED;
                case UNLOAD:
                    return DeliveryStatus.WAITING;
                default:
                    return DeliveryStatus.UNKNOWN;
            }
        return DeliveryStatus.UNKNOWN;
    }
}
