package eu.jankowskirobert.cargosystem.infrastructure.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class RegisterCargoDTO {
    private String name;
    @NotNull
    private String locationFrom;
    @NotNull
    private String locationTo;
    private LocalDate arrival;
}
