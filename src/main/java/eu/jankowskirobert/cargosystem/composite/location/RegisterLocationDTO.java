package eu.jankowskirobert.cargosystem.composite.location;

import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class RegisterLocationDTO {

    @NotNull
    private Address address;
    @NotBlank
    private String companyId;
    private LocalDate availability;
}
