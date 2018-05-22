package eu.jankowskirobert.cargosystem.domain.cargo;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;

@Getter
@Accessors(fluent = true)
public class Schedule {
    private final List<TransitMovement> movementList;

    private Schedule(final List<TransitMovement> movementList) {
        this.movementList = movementList;
    }

    public static Schedule of(final List<TransitMovement> movementList) {
        if (movementList.size() > 0)
            return new Schedule(movementList);
        else
            throw new IllegalScheduleStateException();
    }

    public static Schedule of(final TransitMovement... movementList) {
        if (movementList.length > 0)
            return new Schedule(Arrays.asList(movementList));
        else
            throw new IllegalScheduleStateException();
    }
}
