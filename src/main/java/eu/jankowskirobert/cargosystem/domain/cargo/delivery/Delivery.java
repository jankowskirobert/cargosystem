package eu.jankowskirobert.cargosystem.domain.cargo.delivery;

import eu.jankowskirobert.cargosystem.domain.cargo.Itinerary;
import eu.jankowskirobert.cargosystem.domain.cargo.RouteSpecification;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingActivity;
import eu.jankowskirobert.cargosystem.domain.cargo.handling.HandlingEvent;
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
    private HandlingActivity.Type[] nextActivityType;
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
            this.nextActivityType = this.predictNextEventTypes(event.activity(), routeSpecification, itinerary);
        }
        this.estimatedTimeOfArrival = this.estimate(itinerary);

        this.routingStatus = RoutingStatus.NOT_ROUTED;
    }
    /*
        jesli obecne zdarzenie = zaladunek to nastepne powinno byc wyladunkiem
        jesli obecne zdarzenie = wyladunek to nastepne powinno byc zaladunkiem lub odbiorem lub zwrotem
        jesli obecne zdarzenie = odbior to nastepne moze byc zaladunkiem jesli jest w planie jeszcze jakas mozliwosc poruszania sie
     */
    private HandlingActivity.Type[] predictNextEventTypes(HandlingActivity activity, RouteSpecification routeSpecification, Itinerary itinerary) {
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
            return DeliveryStatus.UNKNOWN;
        return null;
    }
}
