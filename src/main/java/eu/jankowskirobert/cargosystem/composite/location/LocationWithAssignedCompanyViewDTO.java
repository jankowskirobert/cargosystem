package eu.jankowskirobert.cargosystem.composite.location;

import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LocationWithAssignedCompanyViewDTO {
    private String id;
    private Address address;
    private String companyId;
    private String companyName;
    private LocalDate availability;
}
