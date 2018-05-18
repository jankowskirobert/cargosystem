package eu.jankowskirobert.cargosystem.application.cargo.create;

import eu.jankowskirobert.cargosystem.shared.Address;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class NewCargoCommand {
    private String id;
    private String name;
    private BigDecimal weight;
    private String companyId;
    private String transportCompanyId;
    private String locationIdFrom;
    private String locationIdTo;
    private LocalDateTime arrival;
}
