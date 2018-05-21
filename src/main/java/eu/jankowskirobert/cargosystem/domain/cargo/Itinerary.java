package eu.jankowskirobert.cargosystem.domain.cargo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/*
Road transport itinerary
Transa transportu drogowego - cala trasa przejazdu
 */
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Itinerary {
    private List<Leg> legs = Collections.emptyList();

    public static Itinerary empty() {
        return new Itinerary();
    }

    public LocalDateTime getFinalArrival() {
        if(!legs.isEmpty())
            return legs.get(legs.size() - 1).getUnload();
        return null;
    }


}
