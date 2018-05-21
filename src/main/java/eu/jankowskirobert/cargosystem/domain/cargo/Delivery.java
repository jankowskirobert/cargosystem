package eu.jankowskirobert.cargosystem.domain.cargo;

import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
public class Delivery {
    private DeliveryStatus deliveryStatus;
    private Location lastLocation;
    private Transit current;
    private LocalDateTime estimatedTimeOfArrival;
    private HandlingActivity nextActivity;
    private RoutingStatus routingStatus;
    private HandlingEvent handlingEvent;

    public static Delivery of(HandlingEvent event, RouteSpecification routeSpecification, Itinerary itinerary) {
        return new Delivery(event, routeSpecification, itinerary);
    }

    private Delivery(HandlingEvent event, RouteSpecification routeSpecification, Itinerary itinerary) {
        this.handlingEvent = event;
        if(!Objects.isNull(event)) {
            this.deliveryStatus = this.matchDeliveryStatus(event.activity());
            this.lastLocation = this.dispatchLocationFromEvent(event.activity());
            this.current = this.dispatchTransitFromEvent(event.activity());
            this.nextActivity = this.predictNextEvent(event.activity(), routeSpecification, itinerary);
        }
        this.estimatedTimeOfArrival = this.estimate(itinerary);

        this.routingStatus = RoutingStatus.NOT_ROUTED;
    }

    private HandlingActivity predictNextEvent(HandlingActivity activity, RouteSpecification routeSpecification, Itinerary itinerary) {
        switch (activity.type()) {
            case LOAD: {

            }
        }
        return handlingEvent.activity();
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
            return activity.type().obtain();
        return null;
    }
}
