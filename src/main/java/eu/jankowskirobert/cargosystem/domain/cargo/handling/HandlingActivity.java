package eu.jankowskirobert.cargosystem.domain.cargo.handling;

import eu.jankowskirobert.cargosystem.domain.cargo.*;
import eu.jankowskirobert.cargosystem.domain.cargo.delivery.DeliveryStatus;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.Transit;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransportFutureDecision;
import eu.jankowskirobert.cargosystem.domain.cargo.transit.TransportStatusDecision;
import eu.jankowskirobert.cargosystem.domain.location.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/*

 */
@AllArgsConstructor(staticName = "of")
@Accessors(fluent = true)
@Getter
public class HandlingActivity {
    private Type type;
    private Transit transit;
    private Location location;

    public enum Type implements TransportStatusDecision, TransportFutureDecision {
        LOAD {
            @Override
            public HandlingActivity predict(RouteSpecification routeSpecification, Itinerary itinerary) {
                return null;
            }

            @Override
            public DeliveryStatus obtain() {
                return DeliveryStatus.ON_THE_WAY;
            }
        }, UNLOAD {
            @Override
            public HandlingActivity predict(RouteSpecification routeSpecification, Itinerary itinerary) {
                return null;
            }

            @Override
            public DeliveryStatus obtain() {
                return DeliveryStatus.IN_MAGAZINE;
            }
        }, RECEIVE {
            @Override
            public HandlingActivity predict(RouteSpecification routeSpecification, Itinerary itinerary) {
                return null;
            }

            @Override
            public DeliveryStatus obtain() {
                return DeliveryStatus.TRANSFERED;
            }
        }, CLAIM {
            @Override
            public HandlingActivity predict(RouteSpecification routeSpecification, Itinerary itinerary) {
                return null;
            }

            @Override
            public DeliveryStatus obtain() {
                return DeliveryStatus.WAITING;
            }
        }, ANY {
            @Override
            public DeliveryStatus obtain() {
                return null;
            }

            @Override
            public HandlingActivity predict(RouteSpecification routeSpecification, Itinerary itinerary) {
                return null;
            }
        }
    }

}
