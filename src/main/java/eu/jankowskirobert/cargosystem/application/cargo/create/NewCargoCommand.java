package eu.jankowskirobert.cargosystem.application.cargo.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
@Getter
public class NewCargoCommand {
    private String transportNumber;
    private String name;
    private BigDecimal weight;
    private String companyId;
    private String transportCompanyId;
    private String locationIdFrom;
    private String locationIdTo;
    private LocalDate arrival;
}
